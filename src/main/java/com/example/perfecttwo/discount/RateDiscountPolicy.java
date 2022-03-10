package com.example.perfecttwo.discount;

import com.example.perfecttwo.member.Grade;
import com.example.perfecttwo.member.Member;

// 정액 할인 정채
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPersent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPersent / 100;
        }else{
            return 0;
        }
    }
}
