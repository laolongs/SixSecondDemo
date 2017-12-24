package com.example.sixseconddemo.model;

import com.example.sixseconddemo.api.BaseUrl;
import com.example.sixseconddemo.api.HomeApi;
import com.example.sixseconddemo.utils.RetrofitManager;

import okhttp3.OkHttpClient;

/**
 * 作者：author
 * 时间 ：2017/12/22:10:58
 * 说明：
 */

public class RegModel implements IRegModel {

    @Override
    public HomeApi getreg() {
        OkHttpClient client=new OkHttpClient.Builder()
                .build();
        HomeApi user= RetrofitManager.getinstantce(BaseUrl.Baseurl2,client)
                .setcreate(HomeApi.class);
        return user;
    }
}
