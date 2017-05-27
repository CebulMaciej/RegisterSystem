package com.maciejcebula.Service;

import com.maciejcebula.Entity.Question;
import com.maciejcebula.Entity.QuestionType;
import com.maciejcebula.Model.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Maciej Cebula on 27.05.2017.
 */
@Service
public class QuestionTypeService {

    private QuestionTypeRepository questionTypeRepository;

    @Autowired
    public QuestionTypeService(QuestionTypeRepository questionTypeRepository){
        this.questionTypeRepository=questionTypeRepository;
    }

    public List<QuestionType> findAllQuestionTypes(){
        return this.questionTypeRepository.findAllQuestionTypes();
    }
}
