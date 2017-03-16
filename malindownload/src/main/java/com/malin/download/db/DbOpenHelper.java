package com.malin.download.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author: luyanian(luyanian@foxmail.com)
 * Date: 2017/03/16
 * FIXME
 */
class DbOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "malin_download.db";
    private static final int DATABASE_VERSION = 2;

    DbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(Db.RecordTable.CREATE);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            db.beginTransaction();
            try {
                db.execSQL(Db.RecordTable.ALTER_TABLE_ADD_EXTRA1);
                db.execSQL(Db.RecordTable.ALTER_TABLE_ADD_EXTRA2);
                db.execSQL(Db.RecordTable.ALTER_TABLE_ADD_EXTRA3);
                db.execSQL(Db.RecordTable.ALTER_TABLE_ADD_EXTRA4);
                db.execSQL(Db.RecordTable.ALTER_TABLE_ADD_EXTRA5);
                db.execSQL(Db.RecordTable.ALTER_TABLE_ADD_MISSION_ID);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }
    }
}
