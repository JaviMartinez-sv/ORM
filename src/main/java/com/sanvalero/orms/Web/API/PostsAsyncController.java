package com.sanvalero.orms.Web.API;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.sanvalero.orms.Services.PostsAsyncService;
import com.sanvalero.orms.Services.Models.PostDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("v2/postsasync")
public class PostsAsyncController {
    
    private final PostsAsyncService postsService;

    PostsAsyncController(PostsAsyncService postsService){
        this.postsService = postsService;
    }

    @GetMapping()
    public List<PostDTO> GetPosts(@RequestParam(name="userId", required=false, defaultValue = "0") Long userId)
        throws InterruptedException, ExecutionException{
        if(userId !=0){
            return postsService.findByUserIdAsync(userId).get();
        }
        else{
            return postsService.getAllAsync().get();
        }
    }
    
    
}
