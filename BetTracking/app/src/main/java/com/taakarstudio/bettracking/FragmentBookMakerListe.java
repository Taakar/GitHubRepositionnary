package com.taakarstudio.bettracking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBookMakerListe extends Fragment {

    private List<DataBookmaker> bookmakers;
    private RecyclerView recyclerView;

    public FragmentBookMakerListe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_maker_liste, container, false);

        DatabaseManager databaseManager = new DatabaseManager(getContext());
        bookmakers = databaseManager.readAllBookmaker();

        recyclerView = view.findViewById(R.id.recyleurview);
        recyclerView.setAdapter(new AdaptateurView(bookmakers));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));




//        //chargement d'une table !
//        TableLayout tableLayout;
//
//        tableLayout = view.findViewById(R.id.tablebookmaker);
//
//        for (DataBookmaker bookmaker : bookmakers) {
//            TableRow tableRow = new TableRow(getContext());
//
//            tableRow.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
//            TextView textView = new TextView(getContext());
//
//
//            textView.setText(bookmaker.getNom());
//            tableRow.addView(textView);
//            tableLayout.addView(tableRow);
//        }


        // Inflate the layout for this fragment
        return view;
    }

}
