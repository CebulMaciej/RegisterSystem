package com.maciejcebula.Controller;

import com.maciejcebula.Entity.Question;
import com.maciejcebula.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Maciej Cebula on 25.05.2017.
 */
@Controller
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
        this.questionService.addNewQuestion(question);
        question.setIda(id);
        return "redirect:/userQuestionaries/edit/{"+Integer.toString(id)+"}";
    }
}
