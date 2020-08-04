package com.example.dealapps.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author NEJMEDDINE Ayoub
 * @created 03/08/2020 -16:00
 */
@Configuration
public class SpringConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
