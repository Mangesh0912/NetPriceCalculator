package com.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetPriceCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetPriceCalculatorApplication.class, args);
        System.out.println("Hello Net Price Calculator");
    }

}
