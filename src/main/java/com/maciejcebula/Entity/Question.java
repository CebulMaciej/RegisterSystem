package com.maciejcebula.Entity;

/**
 * Created by Maciej Cebula on 25.05.2017.
 */
public class Question {

    private int idp;
    private String questionContent;
    private int idg;
    private int idt;
    private boolean isFirst;

    public Question() {
    }

    public Question(String questionContent, int idg, int idt, boolean isFirst) {
        this.questionContent = questionContent;
        this.idg = idg;
        this.idt = idt;
        this.isFirst = isFirst;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public int getIdg() {
        return idg;
    }

    public void setIdg(int idg) {
        this.idg = idg;
    }

    public int getIdt() {
        return idt;
    }

    public void setIdt(int idt) {
        this.idt = idt;
    }

    public boolean getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(boolean first) {
        isFirst = first;
    }
}
