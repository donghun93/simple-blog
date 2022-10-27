package com.example.simpleblog.service;

import com.example.simpleblog.domain.Member;
import com.example.simpleblog.dto.CreateDto;
import com.example.simpleblog.dto.MemberListDto;
import com.example.simpleblog.exception.MemberException;
import com.example.simpleblog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.simpleblog.exception.MemberErrorCode.MEMBER_DUPLICATED;

@RequiredArgsConstructor
@Service


public class MemberService {
    /**
     * 회원 가입
     */
  private final MemberRepository memberRepository;

    public void createMember(CreateDto member){
        memberRepository.findByEmail(member.getEmail()).ifPresent(mem->{
            throw new MemberException(MEMBER_DUPLICATED);
        });

        Member createMemberInputData = Member.builder()
                .email(member.getEmail())
                .address(member.getAddress())
                .age(member.getAge())
                .name(member.getName())
                .build();

        memberRepository.save(createMemberInputData);
    }
    /**
     * 회원 전체 조회
     */
    public List<MemberListDto> readMemberAllInfo(){


        return memberRepository.findAll().stream()
                .map(MemberListDto::new)
                .collect(Collectors.toList());

        // .stream() == for(Member meberItm : lists)
        // .map(memberItem ->(i) ) == Member memberItm



    }


}
