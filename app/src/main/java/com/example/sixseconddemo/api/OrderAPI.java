package com.example.sixseconddemo.api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 郭金龙 on 2017/12/25.
 */

public interface OrderAPI {
    @POST("order/create")
    @FormUrlEncoded
    Call<ResponseBody> getOrder(@FieldMap Map<String,Object> map);
}
