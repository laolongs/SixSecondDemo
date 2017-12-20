package com.example.sixseconddemo.api;

import com.example.sixseconddemo.bean.LunboBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by one Dream on 2017/12/20.
 */

public interface GetRequest_In {
    @GET("banner/")
    Observable<LunboBean> getLB(@Query("type") String type);
}
