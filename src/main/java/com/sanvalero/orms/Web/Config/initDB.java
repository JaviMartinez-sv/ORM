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
    CommandLineRunner initDataBase(UsersRepository usersRepo,PostsRepository postsRepo ) {

        return args ->{
            usersRepo.save(new UserEntity("User 1"));
            usersRepo.save(new UserEntity("User 2"));

            postsRepo.save(new PostEntity(3L, "Post 1"));
            postsRepo.save(new PostEntity(4L, "Post 2"));
            postsRepo.save(new PostEntity(5L, "Post 3"));
            postsRepo.save(new PostEntity(7L, "Post 4"));
            
            for(int i=0; i<60000; i++){
                postsRepo.save(new PostEntity(2L, "post" + i));
            }
        };

    }
}
