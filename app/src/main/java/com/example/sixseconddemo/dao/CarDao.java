package com.example.sixseconddemo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sixseconddemo.bean.CarBean;
import com.example.sixseconddemo.db.MySQlite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郭金龙 on 2017/12/20.
 */

public class CarDao {
    MySQlite helper;
    public static final String TABLE="car";
    public CarDao(Context context){
        helper=new MySQlite(context);
    }
    public void insert(ContentValues values){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.insert(TABLE,null,values);
        db.close();
    }
    public void delete(String title){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(TABLE,title,new String[]{title});
        db.close();
    }
    public List<CarBean> queryAll(){
        List<CarBean> list=new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String img = cursor.getString(cursor.getColumnIndex("img"));
            String price = cursor.getString(cursor.getColumnIndex("price"));
            CarBean bean=new CarBean(title,img,price);
            list.add(bean);
        }
        db.close();
        return list;
    }
}
