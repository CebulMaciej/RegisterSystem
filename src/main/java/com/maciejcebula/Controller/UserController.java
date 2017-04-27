package com.maciejcebula.Controller;

import com.maciejcebula.Entity.User;
import com.maciejcebula.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Maciej Cebula on 25.04.2017.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes({"name","user"})
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
    public String loginTry(Model model, User user){
        User us=userService.login(user);
        if(us!=null){
            model.addAttribute("name",us.getFirstName()+ " "+ us.getLastName());
            model.addAttribute("user",us);
            return "redirect:/";
        }
        else
        {
            return "redirect:/homebad";
        }
    }

}
