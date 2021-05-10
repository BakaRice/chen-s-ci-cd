package com.ricemarch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@MapperScan("com.ricemarch.chen.mapper")
public class ChenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChenApplication.class, args);
    }

}
