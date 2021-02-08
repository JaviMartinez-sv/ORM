package com.sanvalero.orms.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Users")
@Entity(name= "Users")

public class UserEntity {
    
    
    private @Id @GeneratedValue Long id;
    private String name;
    private long salary;

    public UserEntity(){}

    public UserEntity(String name) {
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

    public long getSalary() {
        return salary;
    }

    public void setSalario(long salary) {
        this.salary = salary;
    }

    public UserEntity(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
    
    
}