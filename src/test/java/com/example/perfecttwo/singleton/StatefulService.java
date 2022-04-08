package com.example.perfecttwo.singleton;

public class StatefulService {

    private int price; // 가격 : 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 문제!
    }

    public int getPrice() {
        return price;
    }
}

//무상태 코드로 만들기
class StatefulServiceGood {

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }
}