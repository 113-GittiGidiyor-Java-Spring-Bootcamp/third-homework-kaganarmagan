package com.sms.kgnarmaganthirdhomeworkmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KgnarmaganThirdhomeworkMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(KgnarmaganThirdhomeworkMainApplication.class, args);


    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}