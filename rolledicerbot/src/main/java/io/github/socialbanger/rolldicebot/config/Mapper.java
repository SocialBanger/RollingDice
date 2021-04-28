package io.github.socialbanger.rolldicebot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

    @Bean
    public ObjectMapper ObjectMapper() {
        ObjectMapper ObjectMapper = new ObjectMapper();
        return ObjectMapper;
    }
}
