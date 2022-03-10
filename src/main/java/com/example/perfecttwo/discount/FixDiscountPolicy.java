package com.example.perfecttwo.discount;

import com.example.perfecttwo.member.Grade;
import com.example.perfecttwo.member.Member;

// 정액 할인 정채
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
