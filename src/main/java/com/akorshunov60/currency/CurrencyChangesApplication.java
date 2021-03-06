package com.akorshunov60.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CurrencyChangesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyChangesApplication.class, args);
    }
}
