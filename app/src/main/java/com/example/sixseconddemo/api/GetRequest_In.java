package com.example.sixseconddemo.api;

import com.example.sixseconddemo.bean.ShouyeBean;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by one Dream on 2017/12/20.
 */

public interface GetRequest_In {
    @GET("campaign/recommend")
    Observable<List<ShouyeBean>> getJiazai();

}
