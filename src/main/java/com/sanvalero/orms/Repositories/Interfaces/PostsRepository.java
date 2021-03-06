package com.sanvalero.orms.Repositories.Interfaces;

import java.util.Collection;

import com.sanvalero.orms.Repositories.Entities.PostEntity;
import com.sanvalero.orms.Repositories.Entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostsRepository 
    extends JpaRepository<PostEntity, Long>{

    
    @Query(value = "SELECT p "+
                    " FROM Posts p" + 
                    " WHERE userId = :userId")
    
    Collection<PostEntity> findByUserId(
        @Param("userId") Long userId
    );

    @Query(value = " SELECT p" +
    " FROM Posts p " + 
    " INNER JOIN Users u ON p.userID = u.id" +
    " WHERE salary > :salary")

    Collection<UserEntity> findBySalary(
    @Param("salary") Long salary
    );
}
