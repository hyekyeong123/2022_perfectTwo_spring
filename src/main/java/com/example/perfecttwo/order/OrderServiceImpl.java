package com.example.perfecttwo.order;

import com.example.perfecttwo.discount.DiscountPolicy;
import com.example.perfecttwo.member.Member;
import com.example.perfecttwo.member.MemberRepository;
import com.example.perfecttwo.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // Ver001 - 할인 정책을 변경하려면 클라이언트인 'OrderServiceImpl'을 변경해야 한다. - OCP 위판
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // Ver002(인터페이스 의존)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//    *******************************************

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // 설계가 잘 된 이유 Order에서는 Discount를 몰라도 됌
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
