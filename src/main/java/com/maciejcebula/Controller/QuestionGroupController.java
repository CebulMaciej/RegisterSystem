package com.maciejcebula.Controller;

import com.maciejcebula.Entity.QuestionGroup;
import com.maciejcebula.Service.QuestionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Maciej Cebula on 27.05.2017.
 */
@Controller
@RequestMapping("/")
@SessionAttributes({"name","User"})
public class QuestionGroupController {
    private QuestionGroupService questionGroupService;

    @Autowired
    public QuestionGroupController(QuestionGroupService questionGroupService){
        this.questionGroupService=questionGroupService;
    }
    @PostMapping(value="/{id}/edit/addquestiongroup")
    public String addQuestionGroup(Model model, @PathVariable int id, QuestionGroup questionGroup){
        questionGroup.setIda(id);
        this.questionGroupService.addNewQuestionGroup(questionGroup);
        return "redirect:/userQuestionaries/edit/"+id;
    }
    @GetMapping(value="/{id}/edit/addquestiongroup")
    public String editQuestionGroups(Model model, @PathVariable int id){
        model.addAttribute("QuestID",id);
        return "addQuestionGroup";
    }


}
