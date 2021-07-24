package com.teambook.mybookdiary.Common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookInfo extends SQLiteOpenHelper {

    public BookInfo(Context context) {
        super(context, "BookInfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE mybook(id INTEGER PRIMARY KEY AUTOINCREMENT, bookname TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS mybook";
        db.execSQL(query);
        onCreate(db);
    }
}
