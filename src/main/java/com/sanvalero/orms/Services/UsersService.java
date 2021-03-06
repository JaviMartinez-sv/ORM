package com.sanvalero.orms.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sanvalero.orms.Repositories.Entities.UserEntity;
import com.sanvalero.orms.Repositories.Interfaces.UsersRepository;
import com.sanvalero.orms.Services.Models.UserDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO>getAll(){
        return usersRepository.findAll().stream()
            .map(x -> modelMapper.map(x, UserDTO.class))
            .collect(Collectors.toList());
    }

    public UserDTO add(UserDTO user){
        UserEntity entityToInsert = modelMapper.map(user, UserEntity.class);
        UserEntity result = usersRepository.save(entityToInsert);
        return modelMapper.map(result, UserDTO.class);
    }

    public UserDTO update(Long ID, UserDTO user){
        UserEntity entityToUpdate = modelMapper.map(user, UserEntity.class);
        UserEntity result = usersRepository.save(entityToUpdate);
        return modelMapper.map(result, UserDTO.class);
    }

    public void delete(Long ID){
        Optional<UserEntity> entityToDelete = usersRepository.findById(ID);
        if(entityToDelete.isPresent())
            usersRepository.delete(entityToDelete.get());
    }

    public Optional<UserDTO> findById(Long id){
        Optional<UserEntity> entity = usersRepository.findById(id);
        if(entity.isPresent())
            return Optional.of(modelMapper.map(entity.get(), UserDTO.class));
        else
            return Optional.empty();
    }
}
