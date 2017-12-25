package com.example.sixseconddemo.api;

import com.example.sixseconddemo.bean.ShouyeBean;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by one Dream on 2017/12/20.
 */

public interface GetRequest_In {
    @GET("campaign/recommend")
    Observable<List<ShouyeBean>> getJiazai();

    @FormUrlEncoded
    @POST("favorite/del?")
    Observable<List<ShouyeBean>> getDel(@FieldMap HashMap<String,String> map);
}
