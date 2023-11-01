package com.example.hotelproject.member.repository;

import com.example.hotelproject.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByMemberId(Long memberId);

    boolean existsByEmail(String email);

    Optional<Member> findMemberByEmail(String email);
}
