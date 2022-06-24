package com.metsoft.erpapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ErpappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpappApplication.class, args);
    }

}
