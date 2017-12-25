package com.example.sixseconddemo.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.sixseconddemo.model.ISCmodel;
import com.example.sixseconddemo.model.SCmodel;
import com.example.sixseconddemo.utils.SharedUtil;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 李倩 on 2017/12/23.
 */

public class SCPresenter {
    Context mContext;
    ISCmodel model;
    public SCPresenter( Context mContext) {
        this.mContext=mContext;
        model=new SCmodel();
    }
    public void showSC(int id){
        String userid = (String) SharedUtil.getInstances().getValueByKey(mContext, "userid", "");
        Log.i("zzzzzzzzzzzzzz", "showSC: "+userid);
        HashMap<String,Object> map=new HashMap<>();
        map.put("user_id",userid);
        map.put("ware_id",id);
        map.put("token","a918d4c8-4361-471f-b1a7-48648165274b");
        model.getsc().getSc(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(mContext,"收藏成功",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}
