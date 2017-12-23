package com.example.sixseconddemo.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.sixseconddemo.MainActivity;
import com.example.sixseconddemo.bean.User;
import com.example.sixseconddemo.model.ILoginModel;
import com.example.sixseconddemo.model.LoginModel;
import com.example.sixseconddemo.msg.LoginRespMsg;
import com.example.sixseconddemo.utils.Contants;
import com.example.sixseconddemo.utils.DESUtil;
import com.example.sixseconddemo.utils.SharedUtil;
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
    Context context;
    public loginpresenter(ILoginview iLoginview,Context context) {
       model=new LoginModel();
       attch(iLoginview);
       this.context=context;
    }
    public void getlogin(){
        Map<String, String> map = new HashMap<>();
        String phone = so.get().getName();
        String password = so.get().getPassword();
        Log.i("----name----", "getlogin: "+phone);
        Log.i("----password----", "getlogin: "+DESUtil.encode(Contants.DES_KEY,password));
        if(TextUtils.isEmpty(phone)){
            Toast.makeText(context,"please input phone",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(context,"please input pw",Toast.LENGTH_SHORT).show();
            return;
        }
        map.put("phone",phone);
        map.put("password", DESUtil.encode(Contants.DES_KEY,password));
       model.getlogin().getlogMap(map)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<LoginRespMsg<User>>() {
                   @Override
                   public void onCompleted() {

                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onNext(LoginRespMsg<User> userLoginRespMsg) {
                       Log.i("--------LoginBean-----", "onNext: ");
                       String token = userLoginRespMsg.getToken();
                       Log.i("token---", "onNext: "+token);
                       User data = userLoginRespMsg.getData();
                       Log.i("getId---", "onNext: "+data.getId());
                       Log.i("getUsername---", "onNext: "+data.getUsername());
                       Log.i("getEmail---", "onNext: "+data.getEmail());
                       Log.i("getMobi---", "onNext: "+data.getMobi());
                       Log.i("getLogo_url---", "onNext: "+data.getLogo_url());
                       SharedUtil.getInstances().saveDatad(context,"flag",true);
                       SharedUtil.getInstances().saveDatad(context,"userid",data.getId().toString());
//                       String  userid = (String) SharedUtil.getInstances().getValueByKey(context, "userid", "");
//                       Log.i("-----userid-----", "onNext: "+userid);
                       context.startActivity(new Intent(context, MainActivity.class));
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
