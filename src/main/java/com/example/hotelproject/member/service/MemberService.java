package com.example.hotelproject.member.service;

import com.example.hotelproject.member.controller.request.MemberCreateRequest;
import com.example.hotelproject.member.controller.response.MemberResponse;
import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.member.repository.MemberRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long create(MemberCreateRequest request) {
        Member user = request.toEntity();
        boolean isExistMember = memberRepository.existsByMemberId(user.getMemberId());
        if (isExistMember) {
            throw new IllegalArgumentException("이미 가입된 회원입니다. : " + user.getMemberId());
        }
        return memberRepository.save(user).getMemberId();
    }

    public List<MemberResponse> findAll() {
        return memberRepository.findAll()
                .stream().map(MemberResponse::of)
                .collect(Collectors.toList());
    }

    public MemberResponse findMemberByMemberId(String email) {
        return memberRepository.findMemberByEmail(email)
                .map(MemberResponse::of)
                .orElseThrow(() -> new EntityNotFoundException("해당 이메일로 가입된 회원이 없습니다. : " + email));
    }

    public void deleteByMemberId(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
