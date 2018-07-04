package com.balderacchi.bettracking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {


//    private TextView textv;
  //  private DatabaseManager DBManager;
    private ormDBManager ormDBM;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        textv = (TextView) findViewById(R.id.TxtBDD);
//        ormDBM = new ormDBManager(this);
//        DBManager = new DatabaseManager(this);
//        DBManager.Insert("Totot");

//        ormDBM.insertBookmaker(new BookmakerData("Winamax"));
//        ormDBM.insertBookmaker(new BookmakerData("BetClic"));
//        ormDBM.insertBookmaker(new BookmakerData("Unibet"));

//        List<BookmakerData> bookmakers = ormDBM.ReadAll();



//        for (BookmakerData UnBookmaker : ormDBM.ReadAll()) {
//            textv.append(UnBookmaker.toString()+"\n\n");
//        }

//        ormDBM.close();


//        DBManager = new DatabaseManager(this);
//        DBManager.Insert("Winamax");
//        DBManager.Insert("BetClic");
//        List<BookmakerData> tpobookmaker = DBManager.ReadAll();
//        for (BookmakerData UnBookmaker : tpobookmaker) {
//            textv.append(UnBookmaker.toString()+"\n\n");
//        }
//        DBManager.close();
    }
}
