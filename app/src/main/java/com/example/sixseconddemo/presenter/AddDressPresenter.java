package com.example.sixseconddemo.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.sixseconddemo.activity.AddressActivity;
import com.example.sixseconddemo.bean.addressSuccessBean;
import com.example.sixseconddemo.model.AddressModel;
import com.example.sixseconddemo.model.IaddressModel;
import com.example.sixseconddemo.utils.SharedUtil;
import com.example.sixseconddemo.view.IaddAddressView;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：author
 * 时间 ：2017/12/25:15:06
 * 说明：
 */

public class AddDressPresenter implements IPresenter<IaddAddressView> {
    SoftReference<IaddAddressView> so;
    IaddressModel model;
    Context context;
    public AddDressPresenter(IaddAddressView view, Context context) {
        model=new AddressModel();
        attch(view);
        this.context=context;
    }
    public void addDress(){
        Map<String, String> map = new HashMap<>();
        final String addr = so.get().getaddr();
        String consignee = so.get().getconsignee();
        String phone = so.get().getphone();
        String s = so.get().getzip_code();
        String userid = (String) SharedUtil.getInstances().getValueByKey(context, "userid", "");
        final String token="a918d4c8-4361-471f-b1a7-48648165274b";
        map.put("user_id",userid);
        map.put("consignee",consignee);
        map.put("phone",phone);
        map.put("addr",addr);
        map.put("zip_code",s);
        map.put("token",token);
        model.getAddress().getaddDress(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<addressSuccessBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(addressSuccessBean addressSuccessBean) {
                        int status = addressSuccessBean.getStatus();
                        if(status==1){
                            Toast.makeText(context,"successful",Toast.LENGTH_SHORT).show();
                            context.startActivity(new Intent(context, AddressActivity.class));
                         }else{
                            Toast.makeText(context,addressSuccessBean.getMessage(),Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
    }
    @Override
    public void attch(IaddAddressView view) {
        so=new SoftReference<IaddAddressView>(view);
    }

    @Override
    public void dettch() {
        so.clear();
    }
}
