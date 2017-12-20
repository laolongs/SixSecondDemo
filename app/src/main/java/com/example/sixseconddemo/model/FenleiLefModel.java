package com.example.sixseconddemo.model;

import com.example.sixseconddemo.api.BaseUrl;
import com.example.sixseconddemo.api.HomeApi;
import com.example.sixseconddemo.utils.RetrofitManager;

import okhttp3.OkHttpClient;

/**
 * Created by 李倩 on 2017/12/20.
 */

public class FenleiLefModel implements IFenleiLeftModel {
    @Override
    public HomeApi getfenlei() {
        OkHttpClient client=new OkHttpClient.Builder()
                .build();
        HomeApi setcreate = RetrofitManager.getinstantce(BaseUrl.Baseurl, client)
                .setcreate(HomeApi.class);
        return setcreate;
    }
}
