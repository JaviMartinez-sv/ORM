package com.sanvalero.orms.Services.Models;

public class UserDTO {
    
    private String name;
    private Long id;
    private long salary;

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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
