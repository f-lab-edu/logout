package com.example.hotelproject;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


public class Example {
    private final String name;
    private final String alias;

    public Example(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }

    public void print() {
        System.out.println("name: " + name);
        System.out.println("alias: " + alias);
    }

    public static void main(String[] args) {
        Example example = new Example("이름", "별명");

        example.print();
        asdf

    }
}
