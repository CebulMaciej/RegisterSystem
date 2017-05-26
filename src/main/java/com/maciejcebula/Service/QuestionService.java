package com.maciejcebula.Service;

import com.maciejcebula.Entity.Question;
import com.maciejcebula.Model.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Maciej Cebula on 25.05.2017.
 */
@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository=questionRepository;
    }
    public List<Question> findAllByQuestionaireID(int QuestID){
        return this.questionRepository.findAllByQuestionaireID(QuestID);
    }
    public void addNewQuestion(Question question){
        this.questionRepository.addNewAnkieta(question);
    }
}
