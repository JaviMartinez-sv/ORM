package com.sanvalero.orms.Services.Models;

public class UserDTO {
    
    private String name;
    private Long id;
    

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
