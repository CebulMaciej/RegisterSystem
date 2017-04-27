package com.maciejcebula.Controller;

import com.maciejcebula.Entity.User;
import com.maciejcebula.Service.QuestionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Maciej Cebula on 27.04.2017.
 */
@RequestMapping("/")
@SessionAttributes({"name","user"})
@Controller
public class QuestionaireController {

    QuestionaireService questionaireService;

    @Autowired
    public QuestionaireController(QuestionaireService question){
        this.questionaireService=question;
    }

    @GetMapping(value ="usersQuestionaries")
    public String findAllQuestionaires(Model model,@SessionAttribute("user") User user){
        model.addAttribute("quests",questionaireService.findAllUserQuestionaries(user.getId()));
        return "usersQuestionaries";
    }
}
