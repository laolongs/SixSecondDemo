package com.example.sixseconddemo.api;

import com.example.sixseconddemo.bean.BestSellerBean;
import com.example.sixseconddemo.bean.FenleiLeft;

import java.util.HashMap;
import java.util.List;

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
    Observable<BestSellerBean> getBeat(@FieldMap HashMap<String,Integer> map);
    //分类
    @POST("course_api/category/list")
    Observable<List<FenleiLeft>> getleft();
}
