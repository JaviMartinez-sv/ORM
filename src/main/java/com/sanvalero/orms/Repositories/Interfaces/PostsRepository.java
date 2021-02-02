package com.sanvalero.orms.Repositories.Interfaces;

import java.util.Collection;

import com.sanvalero.orms.Repositories.Entities.PostEntity;

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
}
