package com.example.sixseconddemo.model;

import com.example.sixseconddemo.api.BaseUrl;
import com.example.sixseconddemo.api.HomeApi;
import com.example.sixseconddemo.utils.MyInterceptor;
import com.example.sixseconddemo.utils.RetrofitManager;

import okhttp3.OkHttpClient;

/**
 * 作者：author
 * 时间 ：2017/12/21:15:21
 * 说明：
 */

public class LoginModel implements ILoginModel {

    @Override
    public HomeApi getlogin() {
        OkHttpClient client=new OkHttpClient.Builder()
                .addNetworkInterceptor(new MyInterceptor())
                .build();
        HomeApi user= RetrofitManager.getinstantce(BaseUrl.Baseurl,client)
                .setcreate(HomeApi.class);
        return user;
    }


}
