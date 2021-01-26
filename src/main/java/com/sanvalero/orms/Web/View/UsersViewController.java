package com.sanvalero.orms.Web.View;

import com.sanvalero.orms.Services.UsersService;
import com.sanvalero.orms.Services.Models.UserDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("users")
public class UsersViewController {
    private final UsersService usersService;

    UsersViewController(UsersService usersService){
        this.usersService = usersService;
    }
    @GetMapping
    public ModelAndView UsersV2(){
        ModelAndView mv = new ModelAndView("listUsers");
        mv.addObject("users", usersService.getAll());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView CreateUser(){
        ModelAndView mv = new ModelAndView("detailUsers");
        mv.addObject("user", new UserDTO());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView EditUser(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("detailUsers");
        var userOrEmpty = usersService.findById(id);
        UserDTO user = new UserDTO();
        if (userOrEmpty.isPresent())
            user = userOrEmpty.get();
        mv.addObject("user", user);
        return mv;
    }
    
}
