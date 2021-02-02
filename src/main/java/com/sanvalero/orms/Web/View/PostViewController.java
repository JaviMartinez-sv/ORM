package com.sanvalero.orms.Web.View;

import com.sanvalero.orms.Services.PostsService;
import com.sanvalero.orms.Services.Models.PostDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("posts")
public class PostViewController {
    private final PostsService postsService;

    PostViewController(PostsService postsService){
        this.postsService = postsService;
    }
    @GetMapping
    public ModelAndView PostsV2(){
        ModelAndView mv = new ModelAndView("listPosts");
        mv.addObject("posts", postsService.getAll());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView CreatePosts(){
        ModelAndView mv = new ModelAndView("detailPosts");
        mv.addObject("user", new PostDTO());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView EditPost(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("detailPosts");
        var postOrEmpty = postsService.findById(id);
        PostDTO post = new PostDTO();
        if (postOrEmpty.isPresent())
            post = postOrEmpty.get();
        mv.addObject("post", post);
        return mv;
    }
}
