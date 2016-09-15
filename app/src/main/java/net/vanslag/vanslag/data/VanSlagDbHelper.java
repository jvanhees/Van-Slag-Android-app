package net.vanslag.vanslag.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JVH on 15/09/16.
 */
public class VanSlagDbHelper extends SQLiteOpenHelper {

    public VanSlagDbHelper(Context context) {
        super(context, VanSlagContract.DATABASE_NAME, null, VanSlagContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VanSlagContract.TeamTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(VanSlagContract.TeamTable.DELETE_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
