package com.example.sixseconddemo.api;

import com.example.sixseconddemo.bean.BestSellerBean;

import java.util.HashMap;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 李倩 on 2017/12/20.
 */

public interface HomeApi {
    //热卖
    @FormUrlEncoded
    @POST("course_api/wares/hot?")
    Observable<BestSellerBean> getBeat(@FieldMap HashMap<Integer,Integer> map);
}
