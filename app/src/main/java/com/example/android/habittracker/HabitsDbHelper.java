package com.example.android.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Enzo on the 18/07/2017.
 */

class HabitsDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habitTracker.db";
    private static final int DATABASE_VERSION = 2;

    public HabitsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

        @Override
        public void onCreate (SQLiteDatabase sqLiteDatabase){
            String CREATE_TABLE_TRACKING_DIARY = "CREATE TABLE " + HabitsContract.HabitEntry.NOME_TAVOLA +
                    "(" + HabitsContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    HabitsContract.HabitEntry.COLONNA_DATA + " INTEGER NOT NULL," +
                    HabitsContract.HabitEntry.COLONNA_ALLENAMENTI + " INTEGER NOT NULL," +
                    HabitsContract.HabitEntry.COLONNA_COMMENTI + " STRING);";
            Log.v("HabitsDbHelper", "creare tavola: " + CREATE_TABLE_TRACKING_DIARY);
            sqLiteDatabase.execSQL(CREATE_TABLE_TRACKING_DIARY);
        }

        @Override
        public void onUpgrade (SQLiteDatabase sqLiteDatabase,int i, int i1){
        }

    public void insertHabits(int date, int habit, String comment) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitsContract.HabitEntry.COLONNA_DATA, date);
        values.put(HabitsContract.HabitEntry.COLONNA_ALLENAMENTI, habit);
        values.put(HabitsContract.HabitEntry.COLONNA_COMMENTI, comment);
        db.insert(HabitsContract.HabitEntry.NOME_TAVOLA, null, values);
    }

    public Cursor readHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitsContract.HabitEntry._ID,
                HabitsContract.HabitEntry.COLONNA_DATA,
                HabitsContract.HabitEntry.COLONNA_ALLENAMENTI,
                HabitsContract.HabitEntry.COLONNA_COMMENTI
        };
        Cursor cursor = db.query(
                HabitsContract.HabitEntry.NOME_TAVOLA,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}