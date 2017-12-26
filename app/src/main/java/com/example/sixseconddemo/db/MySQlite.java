package com.example.sixseconddemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 郭金龙 on 2017/12/20.
 */

public class MySQlite extends SQLiteOpenHelper {
    public MySQlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public MySQlite(Context context) {
        super(context, "Cars", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table car (id integer primary key autoincrement,userid varchar,img varchar,title varchar unique,price varchar,flag varchar)";
        db.execSQL(sql);
        String sql2="create table adds (id integer primary key autoincrement,addid varchar,adduserid varchar,consignee varchar,phone varchar unique,addr varchar,zipCode varchar,isDefault varchar)";
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
