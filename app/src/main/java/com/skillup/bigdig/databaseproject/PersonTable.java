package com.skillup.bigdig.databaseproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PersonTable {

    public static final String TABLE_NAME = "person";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";

    private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME
            + "("
            + COLUMN_ID
            + " integer primary key, "
            + COLUMN_NAME
            + " text default '', "
            + COLUMN_EMAIL
            + " text default '' "
            + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public static void addPerson(Person person, Context context){
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, person.getName());
        cv.put(COLUMN_EMAIL, person.getEmail());
        DbOpenHelper.getInstance(context).getWritableDatabase()
                .insert(TABLE_NAME, null, cv);
    }

    public static void deletePerson(Person person, Context context){
        DbOpenHelper.getInstance(context).getWritableDatabase()
                .delete(TABLE_NAME, COLUMN_ID+"="+person.id, null);
    }

    public static List<Person> getAll(Context context){
        Cursor cursor = DbOpenHelper.getInstance(context).getReadableDatabase()
                .query(TABLE_NAME, null, null, null, null, null, null);

        List<Person> personList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                personList.add(new Person(name, email, id));
            }while(cursor.moveToNext());
        }

        return personList;
    }
}
