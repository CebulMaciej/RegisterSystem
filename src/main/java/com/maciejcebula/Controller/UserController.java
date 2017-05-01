package com.maciejcebula.Controller;

import com.maciejcebula.Entity.User;
import com.maciejcebula.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            return "redirect:/user/panel";
        }
        else
        {
            return "redirect:/homebad";
        }
    }
    @GetMapping(value = "/logout")
    public String page4(@ModelAttribute User user, WebRequest request, SessionStatus status) {
        /**
         * store User ...
         */
        status.setComplete();
        request.removeAttribute("user", WebRequest.SCOPE_SESSION);
        request.removeAttribute("name", WebRequest.SCOPE_SESSION);
        return "redirect:/";
    }
    @GetMapping(value = "/panel")
    public String panel(Model Model){
        return "panel";
    }

}
