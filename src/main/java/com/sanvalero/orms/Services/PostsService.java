package com.sanvalero.orms.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sanvalero.orms.Repositories.Entities.PostEntity;
import com.sanvalero.orms.Repositories.Interfaces.PostsRepository;
import com.sanvalero.orms.Services.Models.PostDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PostsService {
    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<PostDTO>getAll(){
        return postsRepository.findAll().stream()
            .map(x -> modelMapper.map(x, PostDTO.class))
            .collect(Collectors.toList());
    }

    public PostDTO add(PostDTO post){
        PostEntity entityToInsert = modelMapper.map(post, PostEntity.class);
        PostEntity result = postsRepository.save(entityToInsert);
        return modelMapper.map(result, PostDTO.class);
    }

    public PostDTO update(Long ID, PostDTO post){
        PostEntity entityToUpdate = modelMapper.map(post, PostEntity.class);
        PostEntity result = postsRepository.save(entityToUpdate);
        return modelMapper.map(result, PostDTO.class);
    }

    public void delete(Long ID){
        Optional<PostEntity> entityToDelete = postsRepository.findById(ID);
        if(entityToDelete.isPresent())
            postsRepository.delete(entityToDelete.get());
    }

    public Optional<PostDTO> findById(Long id){
        Optional<PostEntity> entity = postsRepository.findById(id);
        if(entity.isPresent())
            return Optional.of(modelMapper.map(entity.get(), PostDTO.class));
        else
            return Optional.empty();
    }
}
