package com.pinocchio2mx.threehundredtangpoems.DB;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by pinocchio2mx on 2016/10/27.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int  VERSION = 0;
    public static final String DATABASE_NAME = "Poem";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
