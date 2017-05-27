package com.maciejcebula.Service;

import com.maciejcebula.Entity.QuestionGroup;
import com.maciejcebula.Model.QuestionGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Maciej Cebula on 27.05.2017.
 */
@Service
public class QuestionGroupService {
    private QuestionGroupRepository questionGroupRepository;
    @Autowired
    public QuestionGroupService(QuestionGroupRepository questionGroupRepository){
        this.questionGroupRepository=questionGroupRepository;
    }

    public List<QuestionGroup> findAllQuestionGroupsByQuestionarieID(int QuestionarieID){
        return this.questionGroupRepository.findAllByQuestionaireID(QuestionarieID);
    }
    public void addNewQuestionGroup(QuestionGroup questionGroup){
        this.questionGroupRepository.addNewQuestionGroup(questionGroup);
    }
    public int findQuestionaryIDbyQuestionGroupID(int id){
        for (QuestionGroup quest:this.questionGroupRepository.findAll()) {
            if(quest.getIdg()==id)
                return quest.getIda();

        }
        return -1;
    }
}
