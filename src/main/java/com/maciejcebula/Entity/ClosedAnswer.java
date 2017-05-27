package com.maciejcebula.Entity;

/**
 * Created by Maciej Cebula on 27.05.2017.
 */
public class ClosedAnswer {
    private int idca;
    private String caContent;

    public ClosedAnswer(String caContent) {
        this.caContent = caContent;
    }

    public ClosedAnswer() {

    }

    public int getIdca() {
        return idca;
    }

    public void setIdca(int idca) {
        this.idca = idca;
    }

    public String getCaContent() {
        return caContent;
    }

    public void setCaContent(String caContent) {
        this.caContent = caContent;
    }
}
