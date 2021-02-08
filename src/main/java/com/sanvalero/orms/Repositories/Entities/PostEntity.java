package com.sanvalero.orms.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Posts")
@Entity(name= "Posts")

public class PostEntity {
    private @Id @GeneratedValue Long id;
    private String name;
    private Long userID;

    public PostEntity(){}

    public PostEntity(String name) {
        this.name = name;

    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id =id;

    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public PostEntity(Long userID, String name) {
        this.userID= userID;
        this.name =name;
    }
    


}
