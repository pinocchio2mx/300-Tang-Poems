package com.pinocchio2mx.threehundredtangpoems.databse;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by pinocchio2mx on 2016/11/4.
 */

public class PoemDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "300tp.db";
    private static final int DATABASE_VERSION = 1;

    public PoemDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getPoems() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = new String[]{"0 _id","work_title", "work_author","work_content"};
        String sqlTables = "collection_works";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }






}
