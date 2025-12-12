package com.app.bankbackend;

import org.springframework.boot.SpringApplication;

public class TestBankBackendApplication {

    public static void main(String[] args) {
        SpringApplication.from(BankBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
