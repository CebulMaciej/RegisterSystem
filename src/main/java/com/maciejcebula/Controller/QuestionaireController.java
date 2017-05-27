package com.maciejcebula.Controller;

import com.maciejcebula.Entity.Question;
import com.maciejcebula.Entity.Questionaire;
import com.maciejcebula.Entity.User;
import com.maciejcebula.Service.QuestionGroupService;
import com.maciejcebula.Service.QuestionService;
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
@RequestMapping("/userQuestionaries")
@SessionAttributes({"name","User"})
@Controller
public class QuestionaireController {

    private QuestionaireService questionaireService;
    private QuestionGroupService questionGroupService;
    private QuestionService questionService;

    @Autowired
    public QuestionaireController(QuestionaireService question,QuestionGroupService questionGroupService,QuestionService questionService){
        this.questionaireService=question;
        this.questionGroupService=questionGroupService;
        this.questionService=questionService;
    }

    @GetMapping()
    public String findAllQuestionaires(Model model,@SessionAttribute("User") User user){
        //model.addAttribute("questions",)
        model.addAttribute("quests",questionaireService.findAllUserQuestionaries(user.getId()));
        return "userQuestionaries";
    }
    @GetMapping(value ="/add")
    public String addingQuestionaires(Model model,@SessionAttribute("User") User user){
        return "addQuestionaries";

    }
    @PostMapping(value = "/add")
    public String addNewQuestionaries(Model model, Questionaire quest,@SessionAttribute("User")User user){
        quest.setId_(user.getId());
        this.questionaireService.addNewQuestionaire(quest);
        return "redirect:/userQuestionaries";
    }
    @PostMapping(value = "/delete/{id}")
    public String deleteQuestionaries(Model model,@PathVariable int id,@SessionAttribute("User") User user){
        List<Questionaire> lista = this.questionaireService.findAllUserQuestionaries(user.getId());
        for(Questionaire quest : lista){
            if(quest.getIda()==id && quest.getId_()==user.getId()) {
                questionaireService.deleteQuestionaireByID(id);
                return "redirect:/userQuestionaries";
            }
        }
        return "redirect:/userQuestionaries";
    }
    @GetMapping(value = "/edit/{id}")
    public String editQuestionary(Model model,@PathVariable int id,@SessionAttribute("User")User user){
        List<Questionaire> lista = this.questionaireService.findAllUserQuestionaries(user.getId());
        for(Questionaire quest : lista){
            if(quest.getIda()==id && quest.getId_()==user.getId()) {
                model.addAttribute("quest",quest);
                model.addAttribute("questiongroups",this.questionGroupService.findAllQuestionGroupsByQuestionarieID(id));
                return "editQuestionary";
            }
        }
        return "error";
    }
}
