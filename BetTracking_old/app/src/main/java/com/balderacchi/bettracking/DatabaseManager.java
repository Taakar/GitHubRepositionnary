package com.balderacchi.bettracking;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "BetTracking.db";
    private static final int DATABASE_VERSION = 1;


   public DatabaseManager(Context context) {
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String strSQL = "CREATE TABLE TBOOKMAKER ("
                            + "     id integer primary key autoincrement,"
                            + "     nom text not null"
                            + ")";
        Log.d("DATABASE","OnCreate");
        db.execSQL(strSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.d("DATABASE","onUpgrade");
    }

    public void Insert(String nom){
       nom = nom.replace("'","''");
       String strSql = "insert into TBOOKMAKER (nom) values ('"+nom+"')";
       this.getWritableDatabase().execSQL(strSql);
        Log.d("DATABASE","Insert");

    }

    public List<BookmakerData> ReadAll() {
        List<BookmakerData> tpoBookmaker = new ArrayList<>();

        //1ère méthode
        String requeteSQL = "Select * from TBOOKMAKER";
        Cursor cursor = this.getReadableDatabase().rawQuery(requeteSQL,null);

        //2ère méthode



        cursor.moveToFirst();

//        while(! cursor.isAfterLast()){
//            BookmakerData bookmaker = new BookmakerData(cursor.getInt(0),cursor.getString(1));
//            tpoBookmaker.add(bookmaker);
//            cursor.moveToNext();
//        }
//        cursor.close();



        return tpoBookmaker;
    }

}
