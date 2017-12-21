package com.example.sixseconddemo.presenter;

import android.util.Log;

import com.example.sixseconddemo.model.ILoginModel;
import com.example.sixseconddemo.model.LoginModel;
import com.example.sixseconddemo.view.ILoginview;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者：author
 * 时间 ：2017/12/21:15:41
 * 说明：
 */

public class loginpresenter implements IPresenter<ILoginview> {
    SoftReference<ILoginview> so;
    ILoginModel model;

    public loginpresenter(ILoginview iLoginview) {
       model=new LoginModel();
       attch(iLoginview);
    }
    public void getlogin(){
        Map<String, String> map = new HashMap<>();
        String name = so.get().getName();
        String password = so.get().getPassword();
        Log.i("----name----", "getlogin: "+name);
        Log.i("----password----", "getlogin: "+password);
        map.put("phone",name);
        map.put("password",password);
        model.getlogin().getMap(map)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String s = response.toString();
                        Log.i("*********11111", "onResponse: "+response.code());
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }
    @Override
    public void attch(ILoginview view) {
        so=new SoftReference<ILoginview>(view);
    }

    @Override
    public void dettch() {
        so.clear();
    }
}
