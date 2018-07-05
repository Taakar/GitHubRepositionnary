package com.taakarstudio.bettracking;

import android.provider.ContactsContract;

import com.j256.ormlite.field.DatabaseField;

public class DataCompte {


    //Membres

    @DatabaseField(generatedId = true)
    private int idCompte;

    @DatabaseField(foreignColumnName = "idBookmaker",foreignAutoCreate = true,foreign = true)
    private DataBookmaker dataBookmaker;

    @DatabaseField
    private String compte;

    @DatabaseField
    private String mdp;

    public int getidCompte() {
        return idCompte;
    }


    public DataCompte() {   }

    public DataCompte(DataBookmaker dataBookmaker, String compte, String mdp) {
        this.setDataBookmaker(dataBookmaker);
        this.setCompte(compte);
        this.setMdp(mdp);
    }


    public int getIdCompte() {
        return idCompte;
    }

    public DataBookmaker getDataBookmaker() {
        return dataBookmaker;
    }

    public void setDataBookmaker(DataBookmaker dataBookmaker) {
        this.dataBookmaker = dataBookmaker;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
