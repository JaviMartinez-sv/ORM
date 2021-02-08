package com.sanvalero.orms.Web.Config;

import com.sanvalero.orms.Services.PostsAsyncService;
import com.sanvalero.orms.Services.PostsService;
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
    PostsService createPostsService(){
        return new PostsService();
    }

    @Bean
    ModelMapper createModelMapper(){
        return new ModelMapper();
    }

    @Bean
    PostsAsyncService createPostAsyncService(){
        return new PostsAsyncService();
    }

}
