package com.example.sixseconddemo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sixseconddemo.bean.showAddressBean;
import com.example.sixseconddemo.db.MySQlite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郭金龙 on 2017/12/20.
 */

public class AddDao {

    MySQlite helper;
    public static final String TABLEADD="adds";
    public AddDao(Context context){
        helper=new MySQlite(context);
    }
    public void insertadd(ContentValues values){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.insert(TABLEADD,null,values);
        db.close();
    }
    public void delete(String adduserId){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(TABLEADD,"adduserid=?",new String[]{adduserId});
        db.close();
    }
    public void update(ContentValues values,String adduserId){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.update(TABLEADD,values,"adduserid=?",new String[]{adduserId});
        db.close();
    }
    public List<showAddressBean> queryAlladd(){
        List<showAddressBean> list=new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(TABLEADD, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            int addid=cursor.getInt(cursor.getColumnIndex("addid"));
            int userid=cursor.getInt(cursor.getColumnIndex("adduserid"));
            String consignee = cursor.getString(cursor.getColumnIndex("consignee"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String addr = cursor.getString(cursor.getColumnIndex("addr"));
            String zipCode = cursor.getString(cursor.getColumnIndex("zipCode"));
            String isDefault = cursor.getString(cursor.getColumnIndex("isDefault"));
            showAddressBean bean=new showAddressBean();
            bean.setId(addid);
            bean.setUserId(userid);
            bean.setConsignee(consignee);
            bean.setPhone(phone);
            bean.setAddr(addr);
            bean.setZipCode(zipCode);
            bean.setIschecked(isDefault);
            list.add(bean);
        }
        db.close();
        return list;
    }
    public List<showAddressBean> queryadd(String flag){
        List<showAddressBean> list=new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(TABLEADD, null, "isDefault=?", new String[]{flag}, null, null, null);
        while (cursor.moveToNext()){
            int addid=cursor.getInt(cursor.getColumnIndex("addid"));
            int userid=cursor.getInt(cursor.getColumnIndex("adduserid"));
            String consignee = cursor.getString(cursor.getColumnIndex("consignee"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String addr = cursor.getString(cursor.getColumnIndex("addr"));
            String zipCode = cursor.getString(cursor.getColumnIndex("zipCode"));
            String isDefault = cursor.getString(cursor.getColumnIndex("isDefault"));
            showAddressBean bean=new showAddressBean();
            bean.setId(addid);
            bean.setUserId(userid);
            bean.setConsignee(consignee);
            bean.setPhone(phone);
            bean.setAddr(addr);
            bean.setZipCode(zipCode);
            bean.setIschecked(isDefault);
            list.add(bean);
        }
        db.close();
        return list;
    }
}
