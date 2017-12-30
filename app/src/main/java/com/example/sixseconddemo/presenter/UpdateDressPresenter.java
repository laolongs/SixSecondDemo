package com.example.sixseconddemo.presenter;

import android.content.Context;
import android.util.Log;

import com.example.sixseconddemo.bean.addressSuccessBean;
import com.example.sixseconddemo.model.IupdateDressModel;
import com.example.sixseconddemo.model.UpdateDressModel;
import com.example.sixseconddemo.view.IupdateAddressView;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：author
 * 时间 ：2017/12/29:19:57
 * 说明：
 */

public class UpdateDressPresenter implements IPresenter<IupdateAddressView> {
    IupdateDressModel model;
    Context context;
    SoftReference<IupdateAddressView> so;
    public UpdateDressPresenter(IupdateAddressView view) {
         attch(view);
         model=new UpdateDressModel();
        this.context=context;
    }
    public void getupdate(){
        Map<String, String> map = new HashMap<>();
        String addr = so.get().getaddr();
        String consignee = so.get().getconsignee();
        String phone = so.get().getphone();
        String s = so.get().getzip_code();
        Boolean getdefault = so.get().getdefault();
        String getid = String.valueOf(so.get().getid());
        String token="a918d4c8-4361-471f-b1a7-48648165274b";
        map.put("id",getid);
        map.put("consignee",consignee);
        map.put("phone",phone);
        map.put("addr",addr);
        map.put("zip_code",s);
        map.put("is_default", String.valueOf(getdefault));
        map.put("token",token);
        model.getupdateData().getupdateDress(map)
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
                        Log.i("update-----success", "onNext: ");
                    }
                });
    }
    @Override

    public void attch(IupdateAddressView view) {
        so=new SoftReference<IupdateAddressView>(view);
    }

    @Override
    public void dettch() {
        so.clear();
    }
}
