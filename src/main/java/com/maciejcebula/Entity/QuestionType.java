package com.maciejcebula.Entity;

/**
 * Created by Maciej Cebula on 27.05.2017.
 */
public class QuestionType {
    private int idt;
    private String typeName;

    public int getIdt() {
        return idt;
    }

    public void setIdt(int idt) {
        this.idt = idt;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public QuestionType(String typeName) {

        this.typeName = typeName;
    }

    public QuestionType() {

    }
}
