package com.skillup.bigdig.databaseproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "databaseProject.db";
    private static final int VERSION = 1;
    private static DbOpenHelper instance;

    public DbOpenHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, VERSION);
    }

    public static DbOpenHelper getInstance(Context context){
        if(instance == null)
            instance = new DbOpenHelper(context);
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        PersonTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        PersonTable.onUpgrade(db, oldVersion, newVersion);
        onCreate(db);
    }
}
