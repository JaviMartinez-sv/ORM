package com.sanvalero.orms.Services.Models;

public class PostDTO {
    
    private String name;
    private Long id;
    private Long UserID;

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
    public Long getUserID(){
        return UserID;
    }
    public void setUserID(Long UserID){
        this.UserID = UserID;
    }
}
