package com.example.perfecttwo.order;

import com.example.perfecttwo.discount.DiscountPolicy;
import com.example.perfecttwo.discount.FixDiscountPolicy;
import com.example.perfecttwo.member.Member;
import com.example.perfecttwo.member.MemberRepository;
import com.example.perfecttwo.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // 설계가 잘 된 이유 Order에서는 Discount를 몰라도 됌
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
