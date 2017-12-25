package com.example.sixseconddemo.model;

import com.example.sixseconddemo.api.BaseUrl;
import com.example.sixseconddemo.api.GetRequest_In;
import com.example.sixseconddemo.api.HomeApi;
import com.example.sixseconddemo.utils.RetrofitManager;

import okhttp3.OkHttpClient;

/**
 * Created by 李倩 on 2017/12/20.
 */

public class SecondModel implements ISecondModel {
    @Override
    public HomeApi getsencond() {
        HomeApi setcreate = RetrofitManager.getinstantce(BaseUrl.Baseurl, new OkHttpClient()).setcreate(HomeApi.class);
        return setcreate;
    }
}
