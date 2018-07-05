package com.taakarstudio.bettracking;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewNom;
    private TextView textViewSolde;


    public ViewHolder(View itemView) {
        super(itemView);

        textViewNom = itemView.findViewById(R.id.textViewNomBookmaker);
        textViewSolde = itemView.findViewById(R.id.textViewSolde);
    }

    public void chargerParDataBookmaker(DataBookmaker dataBookmaker){
        textViewNom.setText(dataBookmaker.getNom());
        textViewSolde.setText("20,00 €");
    }
}
