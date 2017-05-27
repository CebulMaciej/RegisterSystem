package com.maciejcebula.Controller;

import com.maciejcebula.Entity.Question;
import com.maciejcebula.Service.QuestionGroupService;
import com.maciejcebula.Service.QuestionService;
import com.maciejcebula.Service.QuestionTypeService;
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
    private QuestionTypeService questionTypeService;
    private QuestionGroupService questionGroupService;

    @Autowired
    public QuestionController(QuestionService questionService, QuestionTypeService questionTypeService,QuestionGroupService questionGroupService){
        this.questionService=questionService;
        this.questionTypeService=questionTypeService;
        this.questionGroupService=questionGroupService;
    }
    @GetMapping(value="{id}/edit/addquestion")
    public String addNewQuestion(Model model,@PathVariable int id){
        model.addAttribute("QuestID",id);
        model.addAttribute("questionTypes",this.questionTypeService.findAllQuestionTypes());
        return "addQuestion";
    }
    @PostMapping(value="{id}/edit/addquestion")
    public String questionAdd(Model model,@PathVariable int id,Question question){
        question.setIdg(id);
        this.questionService.addNewQuestion(question);

        return "redirect:/userQuestionaries/edit/"+this.questionGroupService.findQuestionaryIDbyQuestionGroupID(id);
    }
}
