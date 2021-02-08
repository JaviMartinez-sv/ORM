package com.sanvalero.orms.Services;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.sanvalero.orms.Repositories.Entities.PostEntity;
import com.sanvalero.orms.Repositories.Interfaces.PostsAsyncRepository;
import com.sanvalero.orms.Services.Models.PostDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PostsAsyncService {
    
    @Autowired
    private PostsAsyncRepository postsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CompletableFuture<List<PostDTO>>getAllAsync(){
        return postsRepository.findAllAsync()
            .whenCompleteAsync((input, exception) -> { })
            .thenApply(input -> EntitiesToDTO(input));
    }

    public CompletableFuture<List<PostDTO>>findByUserIdAsync(Long userId){
        return postsRepository.findByUserIdAsync(userId)
            .whenCompleteAsync((input, exception) -> { })
            .thenApply(input -> EntitiesToDTO(input));
            
    }

    private List<PostDTO> EntitiesToDTO(List<PostEntity> input){
        return input.stream()
        .map(x -> modelMapper.map(x, PostDTO.class))
        .collect(Collectors.toList());
    }
}
