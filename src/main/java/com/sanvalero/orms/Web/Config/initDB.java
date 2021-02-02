package com.sanvalero.orms.Web.Config;

import com.sanvalero.orms.Repositories.Entities.PostEntity;
import com.sanvalero.orms.Repositories.Entities.UserEntity;
import com.sanvalero.orms.Repositories.Interfaces.PostsRepository;
import com.sanvalero.orms.Repositories.Interfaces.UsersRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class initDB {
    @Bean
    CommandLineRunner initDataBase(UsersRepository repository,PostsRepository repository1 ) {

        return args ->{
            repository.save(new UserEntity("User 1"));
            repository.save(new UserEntity("User 2"));
            repository1.save(new PostEntity(3L, "Post 1"));
            repository1.save(new PostEntity(4L, "Post 2"));
        };

    }
}
