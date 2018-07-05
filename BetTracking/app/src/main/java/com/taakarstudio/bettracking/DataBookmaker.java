package com.taakarstudio.bettracking;

import com.j256.ormlite.field.DatabaseField;

public class DataBookmaker {
    @DatabaseField(generatedId = true)
    private int idBookmaker;

    @DatabaseField
    private String nom;

    public DataBookmaker(String bookmaker) {
        this.setNom(bookmaker);
    }


    public DataBookmaker() {    }


    public int getidBookmaker() {
        return idBookmaker;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toString(){
        return "Id :"+idBookmaker+"; nom :"+nom;
    }
}
