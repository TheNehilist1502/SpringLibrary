package com.project.commonModule.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestComponent {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
