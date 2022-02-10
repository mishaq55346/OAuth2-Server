package ru.mikhail.oauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class AuthorizationServerOAuth2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerOAuth2DemoApplication.class, args);
    }

}
