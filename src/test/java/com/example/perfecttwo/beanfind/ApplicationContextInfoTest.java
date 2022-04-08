package com.example.perfecttwo.beanfind;

import com.example.perfecttwo.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){

        // 빈 이름 가져오기
       String[] beanDefinitionNames =  ac.getBeanDefinitionNames();

       // iter 하고 탭 하면 for문 자동완성 도와줌줌
       for (String beanDefinitionName : beanDefinitionNames) {

           // 빈 이름을 가지고 객체 bean 가져오기
            Object bean = ac.getBean(beanDefinitionName);
           System.out.println("[JHG] Object = " + bean + "name = "+beanDefinitionName);
        }
    }


    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationAllBean(){

        // 빈 이름 가져오기
       String[] beanDefinitionNames =  ac.getBeanDefinitionNames();

       // iter 하고 탭 하면 for문 자동완성 도와줌줌
       for (String beanDefinitionName : beanDefinitionNames) {

           // 빈 이름을 가지고 객체 bean 가져오기
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // BeanDefinition.ROLE_APPLICATION : 직접 등록한 빈
           // BeanDefinition.ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("[JHG] Object = " + bean + " / name = "+beanDefinitionName);
            }
        }
    }
}
