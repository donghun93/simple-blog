package com.example.simpleblog.repository;

import com.example.simpleblog.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

   Optional<Member> findByEmail(String email);
}
