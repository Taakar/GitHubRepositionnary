package com.balderacchi.bettracking;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class BookmakerData {

    @DatabaseField(columnName = "id", generatedId = true)
    private int id;

    @DatabaseField
    private String nom;


    public BookmakerData() {

    }

    public BookmakerData(String nom) {
        this.setNom(nom);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toString(){
        return "Id :"+id+"; nom :"+nom;
    }
}
