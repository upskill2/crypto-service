package com.cryptoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class CryptoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoServiceApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public static ApplicationContextProvider contextProvider() {

        return new ApplicationContextProvider();
    }

    public static class ApplicationContextProvider implements ApplicationContextAware {

        private static ApplicationContext context;

        public ApplicationContext getApplicationContext() {
            return context;
        }

        @Override
        public void setApplicationContext(ApplicationContext context) {
            this.context = context;
        }
    }


}
