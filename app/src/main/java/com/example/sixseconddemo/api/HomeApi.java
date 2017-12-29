package com.example.sixseconddemo.api;

import com.example.sixseconddemo.bean.BestSellerBean;
import com.example.sixseconddemo.bean.FenLeiRight;
import com.example.sixseconddemo.bean.FenleiLeft;
import com.example.sixseconddemo.bean.RegBean;
import com.example.sixseconddemo.bean.SoucangBean;
import com.example.sixseconddemo.bean.User;
import com.example.sixseconddemo.bean.addressSuccessBean;
import com.example.sixseconddemo.bean.showAddressBean;
import com.example.sixseconddemo.msg.LoginRespMsg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
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
    //login
    @POST("course_api/auth/login")
    @FormUrlEncoded
    Observable<LoginRespMsg<User>> getlogMap(@FieldMap Map<String,String> map);
    //reg
    @FormUrlEncoded
    @POST("user/reg")
    Observable<RegBean> getregMap(@FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("course_api/wares/list?")
    Observable<FenLeiRight> getright(@FieldMap HashMap<String,Integer> map);

    // user_id=279643&ware_id=2
    @FormUrlEncoded
    @POST("course_api/favorite/create?")
    Call<ResponseBody> getSc(@FieldMap HashMap<String,Object> map);


    //@FormUrlEncoded
    @GET("course_api/favorite/list?")
    Observable<List<SoucangBean>> getscshow(@Query("user_id")String user_id,@Query("token")String token);
    //showAddress
    @GET("course_api/addr/list?")
    Observable<List<showAddressBean>> getaddress(@Query("user_id") String user_id,@Query("token") String token);
    //addAddress
    @FormUrlEncoded
    @POST("course_api/addr/create")
    Observable<addressSuccessBean> getaddDress(@FieldMap Map<String,String> map);
    //deleteAddress
    @FormUrlEncoded
    @POST("course_api/addr/del")
    Observable<addressSuccessBean> getdelDress(@FieldMap Map<String,String> map);
    @FormUrlEncoded
    @POST("course_api/addr/update")
    Observable<addressSuccessBean> getupdateDress(@FieldMap Map<String,String> map);
}
