package com.sanvalero.orms.Repositories.Interfaces;
import com.sanvalero.orms.Repositories.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UsersRepository 
    extends JpaRepository<UserEntity, Long>{

    
    }

