package com.example.sixseconddemo.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.sixseconddemo.activity.LoginActivity;
import com.example.sixseconddemo.bean.RegBean;
import com.example.sixseconddemo.model.IRegModel;
import com.example.sixseconddemo.model.RegModel;
import com.example.sixseconddemo.view.IRegView;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：author
 * 时间 ：2017/12/22:11:07
 * 说明：
 */

public class regpresenter implements IPresenter<IRegView> {
    SoftReference<IRegView> so;
    IRegModel model;
    Context context;
    public regpresenter(IRegView view,Context context) {
        model=new RegModel();
        attch(view);
        this.context=context;
    }
    public void getreg(){
        Map<String, String> map = new HashMap<>();
        String mobile = so.get().getName();
        String password = so.get().getPass();
//        if(phone==""||password==""){
//            Toast.makeText(context,"please wirte without empty",Toast.LENGTH_SHORT).show();
//        }
        Log.i("----name----", "getlogin: "+mobile);
        Log.i("----password----", "getlogin: "+password);
        map.put("mobile",mobile);
        map.put("password",password);
        model.getreg().getregMap(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("-------onErrorreg------", e.getMessage());
                    }

                    @Override
                    public void onNext(RegBean regBean) {
                        String code=regBean.getCode();
                        Log.i("-----onNext------", "onNext: "+code);
                        if(code.equals("0")){
                            Log.i("----做了-----", "onNext: "+"做了");
                            context.startActivity(new Intent(context, LoginActivity.class));
                        }else{
                            Log.i("----没做-----", "onNext: "+"没做");
                            Toast.makeText(context,regBean.getMsg(),Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });

    }
    @Override
    public void attch(IRegView view) {
        so=new SoftReference<IRegView>(view);
    }

    @Override
    public void dettch() {
        so.clear();
    }
}
