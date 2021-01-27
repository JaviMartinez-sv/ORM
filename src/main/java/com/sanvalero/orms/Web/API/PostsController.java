package com.sanvalero.orms.Web.API;

import java.util.List;

import com.sanvalero.orms.Services.PostsService;
import com.sanvalero.orms.Services.Models.PostDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PostsController {
    private final PostsService postsService;

    PostsController(PostsService postsService){
        this.postsService = postsService;
    }

    @GetMapping()
    public List<PostDTO> GetPosts(){
        return postsService.getAll();
    }

    @PostMapping()
    public PostDTO AddUsers(@RequestBody PostDTO post){
        return postsService.add(post);
    }

    @PutMapping("/{id}")
    public PostDTO UpdateUser(@RequestBody PostDTO post,
                                @PathVariable("id") Long id){
        return postsService.update(id, post);
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable("id") Long id){
        postsService.delete(id);
    }
}
