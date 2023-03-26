package de.yasamin.lernkarteiprojekt.config;

import de.yasamin.lernkarteiprojekt.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfig {


    @Bean
    @SessionScope
    public LoginService loginService() {
        return new LoginService();
    }

}
