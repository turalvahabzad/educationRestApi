package com.example.education3.configuration;

import ch.qos.logback.classic.layout.TTLLLayout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfig {

    @Bean
    public TTLLLayout ttllLayout(){
        return new TTLLLayout();

    }
}
