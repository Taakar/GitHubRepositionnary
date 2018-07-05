package com.taakarstudio.bettracking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

public class DatabaseManager extends OrmLiteSqliteOpenHelper{

    private static final String DATABASE_NAME= "BetTracking.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG="DATABASE";
    private final Context context;

    public DatabaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource, DataBookmaker.class);
            TableUtils.createTable(connectionSource, DataCompte.class);

            Log.i(TAG,"Création de la BDD");
        } catch (Exception exception){
            gestionexception("onCreate",exception);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try{
            TableUtils.dropTable(connectionSource,DataBookmaker.class,true);
            TableUtils.dropTable(connectionSource,DataCompte.class,true);
            onCreate(database,connectionSource);

            Log.i(TAG,"Modification structure de la BDD");
        } catch (Exception exception){
            gestionexception("onUpgrade",exception);
        }
    }


    public void insertBookmaker(DataBookmaker dataBookmaker){
        try {
            Dao<DataBookmaker, Integer> dao = getDao(DataBookmaker.class);
            dao.create(dataBookmaker);
            Log.i(TAG, "Insert bookmaker ");
        }catch (Exception exception){
            gestionexception("insertBookmaker",exception);
        }
    }

    public void insertCompte(DataCompte dataCompte){
        try {
            Dao<DataCompte, Integer> dao = getDao(DataCompte.class);
            dao.create(dataCompte);
            Log.i(TAG, "Insert compte ");
        }catch (Exception exception){
            gestionexception("insertCompte",exception);
        }
    }

    public List<DataBookmaker> readAllBookmaker(){
        try{
            Dao<DataBookmaker,Integer> dao = getDao(DataBookmaker.class);
            List<DataBookmaker> bookmakers = dao.queryForAll();

            Log.i(TAG,"ReadAll");
            return bookmakers;

        }catch (Exception exception){
            gestionexception("ReadAllBookmaker",exception);
            return null;
        }
    }



    private void gestionexception(String procedure, Exception exception){
        Log.e(TAG, "EXCEPTION :"+procedure, exception);
    }

}
