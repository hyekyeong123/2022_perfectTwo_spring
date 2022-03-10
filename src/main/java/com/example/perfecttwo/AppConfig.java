package com.example.perfecttwo;

import com.example.perfecttwo.discount.FixDiscountPolicy;
import com.example.perfecttwo.member.MemberService;
import com.example.perfecttwo.member.MemberServiceImpl;
import com.example.perfecttwo.member.MemoryMemberRepository;
import com.example.perfecttwo.order.OrderService;
import com.example.perfecttwo.order.OrderServiceImpl;

// Ver002(OCP, DIP 유지)
// AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다
// AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다
public class AppConfig {

    public MemberService memberService(){

        // MemoryMemberRepository 생성
       return new MemberServiceImpl(new MemoryMemberRepository()); // 주입
        // 클라이언트인 memberServiceImpl 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것 같다고 해서
        // DI(Dependency Injection) 우리말로 의존관계 주입 또는 의존성 주입이라 한다.
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}

/*
    - AppConfig를 통해서 관심사를 확실하게 분리
    - AppConfig는 구체 클래스를 선택한다. 배역에 맞는 담당 배우를 선택한다. 애플리케이션이 어떻게
        동작해야 할지 전체 구성을 책임
*/
