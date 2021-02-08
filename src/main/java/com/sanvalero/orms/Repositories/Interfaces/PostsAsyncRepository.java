package com.sanvalero.orms.Repositories.Interfaces;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.sanvalero.orms.Repositories.Entities.PostEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

public interface PostsAsyncRepository
   extends JpaRepository<PostEntity, Long> {
    
    @Async
    @Query(value = "SELECT p "+
                    " FROM Posts p" + 
                    " WHERE userId = :userId")
    
    CompletableFuture<List<PostEntity>> findByUserIdAsync(
        @Param("userId") Long userId
    );

    @Async
    @Query("select p from Posts p")  
    CompletableFuture<List<PostEntity>> findAllAsync();

}
