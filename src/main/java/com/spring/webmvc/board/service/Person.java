package com.spring.webmvc.board.service;

import lombok.Setter;

//@Setter
public class Person {

    String name;
    final String ssn;

    public Person(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public void setName(String name) {
        this.name = name;
    }


    void m1() {
        Person hong = new Person("홍길동", "991111-1234567");
        hong.setName("김바보");        // 이런식으로 값 변동이 가능하다

    }
}