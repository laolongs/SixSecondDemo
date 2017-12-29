package com.example.sixseconddemo.model;

import com.example.sixseconddemo.api.OrderAPI;
import com.example.sixseconddemo.base.Base;
import com.example.sixseconddemo.utils.RetrofitManager;

import okhttp3.OkHttpClient;

/**
 * Created by 郭金龙 on 2017/12/25.
 */

public class OrderModelList implements IOrderModelList {
    OkHttpClient client=new OkHttpClient.Builder().build();
    @Override
    public OrderAPI serOrderList() {
        OrderAPI setcreate = RetrofitManager.getinstantce(Base.URL, client).setcreate(OrderAPI.class);
        return setcreate;
    }
}
