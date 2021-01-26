package com.sanvalero.orms.Web.Config;

import com.sanvalero.orms.Repositories.Entities.UserEntity;
import com.sanvalero.orms.Repositories.Interfaces.UsersRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class initDB {
    @Bean
    CommandLineRunner initDataBase(UsersRepository repository) {

        return args ->{
            repository.save(new UserEntity("User 1"));
            repository.save(new UserEntity("User 2"));
        };

    }
}
