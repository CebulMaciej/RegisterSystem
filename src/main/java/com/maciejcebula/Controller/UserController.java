package com.maciejcebula.Controller;

import com.maciejcebula.Entity.User;
import com.maciejcebula.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Maciej Cebula on 25.04.2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping(value="/register.try")
    public String registerTry(Model model, User user){
        if(userService.addUserToDataBase(user)){
            return "redirect:/";
        }
        else{
            return "redirect:/badhome";
        }
    }
    @PostMapping(value = "/login.try")
    public String loginTry(Model model,User user){
        if(userService.login(user)){
            model.addAttribute(user);
            return "home_zal";
        }
        else
        {
            return "redirect:/homebad";
        }
    }

}
