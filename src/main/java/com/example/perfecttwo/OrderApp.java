package com.example.perfecttwo;

import com.example.perfecttwo.member.Grade;
import com.example.perfecttwo.member.Member;
import com.example.perfecttwo.member.MemberService;
import com.example.perfecttwo.order.Order;
import com.example.perfecttwo.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);
        System.out.println(order.toString());
        System.out.println(order.calculatePrice());

    }
}
