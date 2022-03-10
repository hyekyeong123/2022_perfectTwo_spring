package com.example.perfecttwo;

import com.example.perfecttwo.member.Grade;
import com.example.perfecttwo.member.Member;
import com.example.perfecttwo.member.MemberService;
import com.example.perfecttwo.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("[JHG] new member : "+member);
        System.out.println("[JHG] findMember : "+findMember);
    }
}
