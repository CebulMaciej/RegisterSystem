package com.maciejcebula.Controller;

import com.maciejcebula.Entity.Questionaire;
import com.maciejcebula.Entity.User;
import com.maciejcebula.Service.QuestionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Maciej Cebula on 27.04.2017.
 */
@RequestMapping("/")
@SessionAttributes({"name","user"})
@Controller
public class QuestionaireController {

    private QuestionaireService questionaireService;

    @Autowired
    public QuestionaireController(QuestionaireService question){
        this.questionaireService=question;
    }

    @GetMapping(value ="usersQuestionaries")
    public String findAllQuestionaires(Model model,@SessionAttribute("user") User user){
        model.addAttribute("quests",questionaireService.findAllUserQuestionaries(user.getId()));
        return "usersQuestionaries";
    }
    @GetMapping(value ="addQuestionaries")
    public String addingQuestionaires(Model model,@SessionAttribute("user") User user){
        return "addQuestionaries";

    }
    @PostMapping(value = "usersQuestionaries/add")
    public String addNewQuestionaries(Model model, Questionaire quest,@SessionAttribute("user")User user){
        quest.setId_(user.getId());
        this.questionaireService.addNewQuestionaire(quest);
        return "redirect:/usersQuestionaries";
    }
    @PostMapping(value = "Questionaries/delete/{id}")
    public String deleteQuestionaries(Model model,@PathVariable int id,@SessionAttribute("user") User user){
        List<Questionaire> lista = this.questionaireService.findAllUserQuestionaries(user.getId());
        for(Questionaire quest : lista){
            if(quest.getIda()==id && quest.getId_()==user.getId()) {
                questionaireService.deleteQuestionaireByID(id);
                return "redirect:/usersQuestionaries";
            }
        }
        return "redirect:/usersQuestionaries";
    }
    @GetMapping(value = "Questionaries/edit/{id}")
    public String editQuestionary(Model model,@PathVariable int id,@SessionAttribute("user")User user){
        List<Questionaire> lista = this.questionaireService.findAllUserQuestionaries(user.getId());
        for(Questionaire quest : lista){
            if(quest.getIda()==id && quest.getId_()==user.getId()) {
                model.addAttribute("quest",quest);
                return "editQuestionary";
            }
        }
        return "unlogged";
    }
}
