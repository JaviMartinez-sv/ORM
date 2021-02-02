package com.sanvalero.orms.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Posts")
@Entity(name= "Posts")

public class PostEntity {
    private @Id @GeneratedValue Long id;
    private String text;

    public PostEntity(){}

    public PostEntity(String text) {
        this.text = text;

    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id =id;

    }
    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    private Long userID;


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public PostEntity(Long userID, String text) {
        this.userID= userID;
        this.text =text;
    }


}
