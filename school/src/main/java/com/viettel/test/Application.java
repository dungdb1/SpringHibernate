package com.viettel.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan (basePackages={"com.viettel"}) 

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}