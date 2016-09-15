package net.vanslag.vanslag.sync;

import android.database.sqlite.SQLiteDatabase;

import net.vanslag.vanslag.data.VanSlagDbHelper;

/**
 * Created by JVH on 16/09/16.
 */
public class VanSlagSyncer {

    SQLiteDatabase db = VanSlagDbHelper.getWritableDatabase(getApplicationContext());

}
