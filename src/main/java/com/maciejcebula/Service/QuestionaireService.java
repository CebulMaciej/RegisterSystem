package com.maciejcebula.Service;

import com.maciejcebula.Entity.Questionaire;
import com.maciejcebula.Model.QuestionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Maciej Cebula on 27.04.2017.
 */
@Service
public class QuestionaireService {
    private QuestionaireRepository questionaireRepository;

    @Autowired
    public QuestionaireService(QuestionaireRepository repo){
        this.questionaireRepository =repo;
    }

    public void addNewQuestionaire(Questionaire quest){
        questionaireRepository.addNewQuestionaire(quest);
    }
    public List<Questionaire> findAllUserQuestionaries(int id){
        return this.questionaireRepository.findUsersAllQuestionaries(id);
    }
    public void deleteQuestionaireByID(int id){
        this.questionaireRepository.deleteQuestionaire(id);
    }
}
