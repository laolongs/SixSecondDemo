package com.example.sixseconddemo.model;

import com.example.sixseconddemo.api.BaseUrl;
import com.example.sixseconddemo.api.HomeApi;
import com.example.sixseconddemo.utils.RetrofitManager;

import okhttp3.OkHttpClient;

/**
 * Created by one Dream on 2017/12/23.
 */

public class SCshowmodel implements ISCShowmodel{




    @Override
    public HomeApi scshow() {
        OkHttpClient client=new OkHttpClient.Builder()
                .build();
        HomeApi setcreate = RetrofitManager.getinstantce(BaseUrl.Baseurl, client)
                .setcreate(HomeApi.class);
        return setcreate;
    }
}
