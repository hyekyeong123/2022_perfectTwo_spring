package com.example.perfecttwo;

import com.example.perfecttwo.discount.DiscountPolicy;
import com.example.perfecttwo.discount.FixDiscountPolicy;
import com.example.perfecttwo.discount.RateDiscountPolicy;
import com.example.perfecttwo.member.MemberService;
import com.example.perfecttwo.member.MemberServiceImpl;
import com.example.perfecttwo.member.MemoryMemberRepository;
import com.example.perfecttwo.order.OrderService;
import com.example.perfecttwo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
       return new MemberServiceImpl(memberRepository()); // 주입
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}

