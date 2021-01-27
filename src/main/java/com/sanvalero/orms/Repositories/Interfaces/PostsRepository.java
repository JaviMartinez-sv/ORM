package com.sanvalero.orms.Repositories.Interfaces;

import com.sanvalero.orms.Repositories.Entities.PostEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository 
    extends JpaRepository<PostEntity, Long>{
    
}
