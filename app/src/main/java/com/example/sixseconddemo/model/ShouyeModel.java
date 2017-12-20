package com.example.sixseconddemo.model;


import com.example.sixseconddemo.api.GetRequest_In;
import com.example.sixseconddemo.base.Base;
import com.example.sixseconddemo.utils.RetrofitManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by one Dream on 2017/12/20.
 */

public class ShouyeModel implements IshouyeModel{

    @Override
    public GetRequest_In Shuju() {

        GetRequest_In request_in = RetrofitManager.getinstantce(Base.URL, new OkHttpClient()).setcreate(GetRequest_In.class);
        return  request_in;

    }
}
