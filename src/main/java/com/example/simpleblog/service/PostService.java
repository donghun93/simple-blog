package com.example.simpleblog.service;

import com.example.simpleblog.domain.Member;
import com.example.simpleblog.domain.Post;
import com.example.simpleblog.exception.MemberException;
import com.example.simpleblog.exception.PostException;
import com.example.simpleblog.repository.MemberRepository;
import com.example.simpleblog.repository.PostRepository;
import com.example.simpleblog.request.CreatePost;
import com.example.simpleblog.request.UpdatePost;
import com.example.simpleblog.response.PostDetailResponse;
import com.example.simpleblog.response.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.simpleblog.exception.MemberErrorCode.MEMBER_NOT_FOUND;
import static com.example.simpleblog.exception.PostErrorCode.POST_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createPost(Long memberId, CreatePost createPost) {
        Member findMember = getMemberInternal(memberId);
        Post post = createPost.toEntity(findMember);
        postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long postId) {
        getPostInternal(postId).delete();
    }

    @Transactional
    public void updatePost(Long postId, UpdatePost updatePost) {
        getPostInternal(postId).update(updatePost.getTitle(), updatePost.getContent());
    }

    public PostDetailResponse getPost(Long postId) {
        return PostDetailResponse.of(getPostInternal(postId));
    }

    public Page<PostListResponse> getPostList(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(PostListResponse::of);
    }

    private Member getMemberInternal(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MEMBER_NOT_FOUND));
    }

    private Post getPostInternal(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostException(POST_NOT_FOUND));
    }
}

