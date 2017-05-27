package com.maciejcebula.Controller;

import com.maciejcebula.Entity.Question;
import com.maciejcebula.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Maciej Cebula on 25.05.2017.
 */
@Controller
@SessionAttributes({"name","User"})
@RequestMapping("/")
public class QuestionController {
    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService=questionService;
    }
    @GetMapping(value="{id}/edit/addquest")
    public String addNewQuestion(Model model,@PathVariable int id){
        model.addAttribute("QuestID",id);
        return "addQuestion";
    }
    @PostMapping(value="{id}/edit/addquest")
    public String questionAdd(Model model,@PathVariable int id,Question question){
        question.setIda(id);
        this.questionService.addNewQuestion(question);
        return "redirect:/userQuestionaries/edit/"+id;
    }
}
