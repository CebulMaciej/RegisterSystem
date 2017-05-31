package com.maciejcebula.Entity;

import java.util.Date;

/**
 * Created by Maciej Cebula on 27.04.2017.
 */
public class Questionaire {
    private int ida;
    private String title;
    private int id_;

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }




    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Questionaire(String title, int id_) {

        //this.ida = ida;
        this.title=title;
        this.id_ = id_;
    }

    public Questionaire() {

    }
}
