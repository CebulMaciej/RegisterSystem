package com.maciejcebula.Entity;

/**
 * Created by Maciej Cebula on 25.05.2017.
 */
public class Question {
    private int idp;
    private String name;
    private int ida;

    public Question(String name, int ida) {
        this.name = name;
        this.ida = ida;
    }

    public int getIdp() {
        return idp;
    }

    public Question() {
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }
}
