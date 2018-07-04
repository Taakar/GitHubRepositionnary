package com.balderacchi.bettracking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.ArrayList;
import java.util.List;

public class ormDBManager extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "BetTracking.db";
    private static final int DATABASE_VERSION = 2;


    public ormDBManager(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i("DATABASE", "Début Création BDD");
            TableUtils.createTable(connectionSource,BookmakerData.class);
            Log.i("DATABASE", "Création BDD");
        }catch (Exception exception){
            Log.e("DATABASE", "Erreur lors de la création de la base de données", exception);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i("DATABASE", "upgrade BDD");
           TableUtils.dropTable(connectionSource,BookmakerData.class,true);
           this.onCreate(database,connectionSource);

        }catch (Exception exception){
            Log.e("DATABASE", "Erreur lors de la mise à jours de la base de données", exception);
        }
    }

    public void insertBookmaker (BookmakerData bookmaker){
        try {
            Dao<BookmakerData, Integer> dao = getDao(BookmakerData.class);
            dao.create(bookmaker);
            Log.i("DATABASE", "Insert ");
        }catch (Exception exception){
            Log.e("DATABASE", "Erreur lors d'ajout de la base de données", exception);
        }
    }

    public List<BookmakerData> ReadAll () {
        try {
            Dao<BookmakerData, Integer> dao = getDao(BookmakerData.class);
            List<BookmakerData> bookmakers = dao.queryForAll();

            Log.i("DATABASE", "RealAll ");

            return bookmakers;
        }catch (Exception exception){
            Log.e("DATABASE", "Erreur lors d'ajout de la base de données", exception);
            return null;
        }

    }
}
