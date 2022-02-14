package ru.mikhail.oauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthorizationServerOAuth2DemoApplication {
    public static void main(String[] args) {
//        System.out.println(passwordEncoder().encode("test1"));
//        System.out.println(passwordEncoder().encode("test2"));
        SpringApplication.run(AuthorizationServerOAuth2DemoApplication.class, args);
    }

//    public static BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
