package com.maciejcebula.Entity;

/**
 * Created by Maciej Cebula on 27.04.2017.
 */
public class Questionaire {
    private int ida;
    private String Nazwa;
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

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public Questionaire(String nazwa, int id_) {

        //this.ida = ida;
        Nazwa = nazwa;
        this.id_ = id_;
    }

    public Questionaire() {

    }
}
