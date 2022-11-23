package com.example.task_1_2.DB;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "recipesDb";
    public static final String TABLE_RESIPE = "recipes";

    public static final String KEY_ID = "_id";
    public static final String RESIPE_NAME = "recipe";
    public static final String TECHNOLOGY = "technology";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version,  DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
               db.execSQL("create table " + TABLE_RESIPE + "(" + KEY_ID
                + " integer primary key," + RESIPE_NAME + " text," + TECHNOLOGY + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_RESIPE);

        onCreate(db);
    }
}
