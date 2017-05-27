package com.maciejcebula.Entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Maciej Cebula on 27.05.2017.
 */
public class Pomocnicza {
    private QuestionGroup object;
    private List<Question> list;

    public Pomocnicza(QuestionGroup object, List<Question> list) {
        this.object = object;
        this.list = list;
    }

    public Pomocnicza() {
        //list = new ArrayList<Question>();
    }

    public QuestionGroup getObject() {
        return object;
    }

    public void setObject(QuestionGroup object) {
        this.object = object;
    }

    public List<Question> getList() {
        return list;
    }

    public void setList(List<Question> list) {
        this.list = list;
    }
}
