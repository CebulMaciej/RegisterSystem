package com.maciejcebula.Entity;

/**
 * Created by Maciej Cebula on 27.05.2017.
 */
public class QuestionGroup {
    private int idg;
    private String questionGroupName;
    private int ida;
    private boolean isMetrics;

    public int getIdg() {
        return idg;
    }

    public void setIdg(int idg) {
        this.idg = idg;
    }

    public String getQuestionGroupName() {
        return questionGroupName;
    }

    public void setQuestionGroupName(String questionQroupName) {
        this.questionGroupName = questionQroupName;
    }

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    public boolean getIsMetrics() {
        return isMetrics;
    }

    public void setIsMetrics(boolean metrics) {
        isMetrics = metrics;
    }

    public QuestionGroup(String questionGroupName, int ida, boolean isMetrics) {

        this.questionGroupName = questionGroupName;
        this.ida = ida;
        this.isMetrics = isMetrics;
    }

    public QuestionGroup() {

    }
}
