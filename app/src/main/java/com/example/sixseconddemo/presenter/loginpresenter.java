package com.example.sixseconddemo.presenter;

import android.util.Log;

import com.example.sixseconddemo.bean.User;
import com.example.sixseconddemo.model.ILoginModel;
import com.example.sixseconddemo.model.LoginModel;
import com.example.sixseconddemo.msg.LoginRespMsg;
import com.example.sixseconddemo.view.ILoginview;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        String phone = so.get().getName();
        String password = so.get().getPassword();
        Log.i("----name----", "getlogin: "+phone);
        Log.i("----password----", "getlogin: "+password);
        map.put("phone",phone);
        map.put("password",password);
        model.getlogin().getMap(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginRespMsg<User>>() {
                    @Override
                    public void onCompleted() {
                        Log.i("onCompleted*******", "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("onError******", "onCompleted: ");
                    }

                    @Override
                    public void onNext(LoginRespMsg<User> userLoginRespMsg) {
                        Log.i("onNext*******", "onCompleted: ");
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
