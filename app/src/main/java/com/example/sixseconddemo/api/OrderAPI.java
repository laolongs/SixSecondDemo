package com.example.sixseconddemo.api;

import com.example.sixseconddemo.bean.OrderBean;
import com.example.sixseconddemo.bean.OrderlistBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 郭金龙 on 2017/12/25.
 */

public interface OrderAPI {
    @POST("order/create")
    @FormUrlEncoded
    Observable<OrderBean> getOrder(@FieldMap Map<String,Object> map);
    @GET("order/list")
    Observable<OrderlistBean> getOrderList(@Query("user_id") String userid,@Query("status") int status,@Query("token") String token);
}
