package com.example.sixseconddemo.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 郭金龙 on 2017/11/14.
 */

public class RetrofitManager {
   private String baseUrl;
    private Retrofit retrofit;
    OkHttpClient client;
    private  static RetrofitManager retrofitManager;
    private RetrofitManager(){}
    private RetrofitManager(String baseUrl, OkHttpClient client) {
        this.baseUrl = baseUrl;
        this.client = client;
        initRetrofit();
    }

    public static RetrofitManager getinstantce(String baseUrl, OkHttpClient client){
//        if(retrofitManager==null){
            retrofitManager=new RetrofitManager(baseUrl,client);
//        }
        return retrofitManager;
    }

    public void initRetrofit(){
        retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public <T> T setcreate(Class<T> regsServer){
        return retrofit.create(regsServer);
    }
}
