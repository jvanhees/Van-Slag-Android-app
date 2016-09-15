package net.vanslag.vanslag.data;

import android.provider.BaseColumns;

/**
 * Created by JVH on 15/09/16.
 */
public final class VanSlagContract {

    public static final  int    DATABASE_VERSION   = 1;
    public static final  String DATABASE_NAME      = "VanSlag.db";
    private static final String TEXT_TYPE          = " TEXT";
    private static final String INT_TYPE           = " INTEGER";
    private static final String COMMA_SEP          = ",";

    private static final String TEAMS_TABLE_NAME = "teams";


    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private VanSlagContract() {}

    /* Inner class that defines the table contents */
    public static abstract class TeamTable implements BaseColumns {

        public static final String TABLE_NAME = "teams";

        public static final String COLUMN_NAME_VANSLAG_ID = "vanSlagId";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_SLUG = "slug";
        public static final String COLUMN_NAME_SEASON_ID = "seasonId";
        public static final String COLUMN_NAME_CAPTAIN_ID = "captainId";
        public static final String COLUMN_NAME_PICTURE_ID = "pictureId";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_VANSLAG_ID + INT_TYPE + COMMA_SEP +
                COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_SLUG + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_SEASON_ID + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_CAPTAIN_ID + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_PICTURE_ID + TEXT_TYPE + " );";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}

