package com.example.hotelproject.member.controller;

import com.example.hotelproject.member.controller.request.MemberCreateRequest;
import com.example.hotelproject.member.controller.response.MemberResponse;
import com.example.hotelproject.member.service.MemberService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    @ApiOperation(value = "member 등록/생성", notes = "신규 member를 등록/생성합니다.")
    public Long createMember(@RequestBody MemberCreateRequest request) {
        return memberService.create(request);
    }

    @GetMapping
    @ApiOperation(value = "member 전체 조회", notes = "기존 member를 전체 조회합니다.")
    public List<MemberResponse> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/{memberId}")
    @ApiOperation(value = "member 검색", notes = "member를 검색합니다.")
    public MemberResponse findMemberByMemberId(@PathVariable("memberId") String id) {
        return memberService.findMemberByMemberId(id);
    }

    @DeleteMapping("/{memberId}")
    @ApiOperation(value = "member 삭제", notes = "해당 유저를 삭제합니다.")
    public void deleteByMemberId(@PathVariable("memberId") Long memberId) {
        memberService.deleteByMemberId(memberId);
    }
}
