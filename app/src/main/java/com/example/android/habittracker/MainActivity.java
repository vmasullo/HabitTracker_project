package com.example.android.habittracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HabitsDbHelper habitsDbHelper = new HabitsDbHelper(this);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);
        int dateInt = Integer.parseInt(dateString);

        habitsDbHelper.insertHabits(dateInt, HabitsContract.HabitEntry.PROGRAMMA,
                "PROGRAMMA");
        habitsDbHelper.insertHabits(dateInt, HabitsContract.HabitEntry.TEMPO_LIBERO,
                "TEMPO_LIBERO");
        habitsDbHelper.insertHabits(dateInt, HabitsContract.HabitEntry.ALLENAMENTI,
                "ALLENAMENTI");
        Cursor cursor = habitsDbHelper.readHabits();
        while (cursor.moveToNext()) {
        }
    }
}
