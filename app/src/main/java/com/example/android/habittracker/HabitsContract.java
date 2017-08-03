package com.example.android.habittracker;

import android.provider.BaseColumns;

/**
 * Created by Enzo on the 18/07/2017.
 */

class HabitsContract {

    public static final class HabitEntry implements BaseColumns {
        public static final String NOME_TAVOLA = "rilevamento_giornaliero";
        public static final String _ID = BaseColumns._ID;
        public static final String COLONNA_DATA = "data";
        public static final String COLONNA_ALLENAMENTI = "allenamenti";
        public static final String COLONNA_COMMENTI = "commenti";
        public static final int TEMPO_LIBERO = 1;
        public static final int PROGRAMMA = 2;
        public final static int ALLENAMENTI = 3;
    }
}
