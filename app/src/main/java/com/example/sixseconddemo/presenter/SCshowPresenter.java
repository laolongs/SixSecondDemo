package com.example.sixseconddemo.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.sixseconddemo.adapter.MyShowAdaoer;
import com.example.sixseconddemo.api.HomeApi;
import com.example.sixseconddemo.bean.SoucangBean;
import com.example.sixseconddemo.model.ISCShowmodel;
import com.example.sixseconddemo.model.ISCmodel;
import com.example.sixseconddemo.model.IshouyeModel;
import com.example.sixseconddemo.model.SCmodel;
import com.example.sixseconddemo.model.SCshowmodel;
import com.example.sixseconddemo.utils.SharedUtil;
import com.example.sixseconddemo.view.IFifstView;
import com.example.sixseconddemo.view.ISCshowView;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by one Dream on 2017/12/23.
 */

public class SCshowPresenter implements IPresenter<ISCshowView>{
    Context mContext;
    SoftReference<ISCshowView> reference;
    SCshowmodel model;


    public SCshowPresenter(Context mContext,ISCshowView reference) {
        this.mContext= mContext;
        attch(reference);
        this.model = new SCshowmodel();
    }

    public void showSC(){
        String userid = (String) SharedUtil.getInstances().getValueByKey(mContext, "userid", "");
        Log.i("zzzzzzzzzzzzzz", "showSC: "+userid);
        HashMap<String,Object> map=new HashMap<>();
        map.put("user_id",userid);
        map.put("token","a918d4c8-4361-471f-b1a7-48648165274b");
//        model.scshow().getscshow(map).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<List<SoucangBean>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i("================", "onError: "+e);
//            }
//
//            @Override
//            public void onNext(List<SoucangBean> soucangBeans) {
//                reference.get().setJiazai(soucangBeans);
//            }
//        });
        model.scshow().getscshow(userid,"a918d4c8-4361-471f-b1a7-48648165274b").observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<List<SoucangBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("================", "onError: "+e);
            }

            @Override
            public void onNext(List<SoucangBean> soucangBeans) {
                reference.get().setJiazai(soucangBeans);
            }
        });
    }

    @Override
    public void attch(ISCshowView view) {
        reference=new SoftReference<ISCshowView>(view);
    }

    @Override
    public void dettch() {

    }
}
