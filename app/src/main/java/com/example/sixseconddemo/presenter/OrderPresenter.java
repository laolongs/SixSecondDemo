package com.example.sixseconddemo.presenter;

import android.util.Log;

import com.example.sixseconddemo.model.IOrderModel;
import com.example.sixseconddemo.model.OrderModel;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 郭金龙 on 2017/12/25.
 */

public class OrderPresenter implements IPresenter {
    public IOrderModel model;
    public OrderPresenter(){
        model=new OrderModel();
    }
    public void showOrder(Map map){
        model.setOrder().getOrder(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("------onResponse------", "onResponse: "+response.toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("------onFailure------", "onResponse: ");

            }
        });
    }
    @Override
    public void attch(Object view) {

    }

    @Override
    public void dettch() {

    }
}
