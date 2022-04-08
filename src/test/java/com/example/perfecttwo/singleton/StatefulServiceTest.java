package com.example.perfecttwo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingletonBad() {

        ApplicationContext ac = new
                AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService",
                StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService",
                StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        statefulService1.order("userA", 10000);

        //ThreadB: B사용자 20000원 주문
        statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        int price = statefulService1.getPrice();

        //ThreadA: 사용자A는 10000원을 기대했지만, 기대와 다르게 20000원 출력
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    @Test
    void statefulServiceSingletonGood() {

        ApplicationContext ac = new
                AnnotationConfigApplicationContext(TestConfig.class);

        StatefulServiceGood statefulService1 =
                ac.getBean("statefulServiceGood", StatefulServiceGood.class);

        StatefulServiceGood statefulService2 =
                ac.getBean("statefulServiceGood", StatefulServiceGood.class);

        //ThreadA: A사용자 10000원 주문
        int userPrice = statefulService1.order("userA", 10000);

        //ThreadB: B사용자 20000원 주문
        int userPrice2 = statefulService2.order("userB", 20000);


        //ThreadA: 사용자A는 10000원을 기대했지만, 기대와 다르게 20000원 출력
        System.out.println("userPrice = " + userPrice);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

        @Bean
        public StatefulServiceGood statefulServiceGood() {
            return new StatefulServiceGood();
        }
    }
}