package com.maciejcebula.Controller;

import com.maciejcebula.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Maciej Cebula on 25.04.2017.
 */
@Controller
@RequestMapping("/")
@SessionAttributes({"name","user"})
public class ViewController {
    @GetMapping
    public String home(Model model){
        return "home";
    }
    @GetMapping("/home")
    public String home2(Model model){
        return "home";
    }
    @GetMapping(path="/login")
    public String login(Model model){
        return "login";
    }
    @GetMapping(path="/register")
    public String register(Model model){
        return "register";
    }
    @GetMapping(path="/home_zal")
    public String zalogowano(Model model){
        return "home_zal";
    }
    @GetMapping(path="/*/home")
    public String homee(Model model){
        return "home";
    }
}
