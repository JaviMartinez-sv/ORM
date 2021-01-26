package com.sanvalero.orms.Web.Config;

import com.sanvalero.orms.Services.UsersService;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DI {
    @Bean
    UsersService createUsersService(){
        return new UsersService();
    }

    @Bean
    ModelMapper createModelMapper(){
        return new ModelMapper();
    }

}
