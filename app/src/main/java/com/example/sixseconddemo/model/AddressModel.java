package com.example.sixseconddemo.model;

import com.example.sixseconddemo.api.BaseUrl;
import com.example.sixseconddemo.api.HomeApi;
import com.example.sixseconddemo.utils.RetrofitManager;

import okhttp3.OkHttpClient;

/**
 * 作者：author
 * 时间 ：2017/12/25:10:51
 * 说明：
 */

public class AddressModel implements IaddressModel {
    @Override
    public HomeApi getAddress() {
        OkHttpClient client=new OkHttpClient.Builder()
                .build();
        HomeApi user= RetrofitManager.getinstantce(BaseUrl.Baseurl,client)
                .setcreate(HomeApi.class);
        return user;
    }
}
