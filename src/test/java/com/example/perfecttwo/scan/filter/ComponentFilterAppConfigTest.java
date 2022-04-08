package com.example.perfecttwo.scan.filter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        BeanA beanA = ac.getBean("beanA", BeanA.class);
        assertThat (beanA).isNotNull();

        // ac.getBean("beanB", BeanB.class) 할때 에러가 발생해야함
        assertThrows(
            NoSuchBeanDefinitionException.class,
            () -> ac.getBean("beanB", BeanB.class)
        );
    }

//  ***************************************************************
    @Configuration
    @ComponentScan(
        includeFilters = @ComponentScan.Filter(
            type= FilterType.ANNOTATION,
            classes = MyIncludeComponent.class
        ),

        // type= FilterType.ANNOTATION - 기본값이므로 생략가능
        excludeFilters = @ComponentScan.Filter(
            classes = MyExcludeComponent.class
        )
    )
    static class ComponentFilterAppConfig{

    }
}
