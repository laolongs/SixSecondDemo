package com.example.sixseconddemo.presenter;

import android.content.Context;
import android.util.Log;

import com.example.sixseconddemo.bean.showAddressBean;
import com.example.sixseconddemo.model.AddressModel;
import com.example.sixseconddemo.model.IaddressModel;
import com.example.sixseconddemo.utils.SharedUtil;
import com.example.sixseconddemo.view.addressview;

import java.lang.ref.SoftReference;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：author
 * 时间 ：2017/12/25:10:53
 * 说明：
 */

public class AddressPresenter implements IPresenter<addressview> {
    SoftReference<addressview> so;
   IaddressModel model;
    Context context;
    public AddressPresenter(addressview view,Context context) {
        model=new AddressModel();
        attch(view);
        this.context=context;
    }
    public void showAddress(){
        Log.i("-----gogogogogog-----", "showAddress: ");
        String userid = (String) SharedUtil.getInstances().getValueByKey(context, "userid", "");
        Log.i("-----useridid-----", "showAddress: "+userid);
        String token="a918d4c8-4361-471f-b1a7-48648165274b";
        model.getAddress().getaddress(userid,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<showAddressBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("-------onerrror------", "onError: ");
                    }

                    @Override
                    public void onNext(List<showAddressBean> showAddressBeans) {
                        Log.i("-------onnext------", "onError: ");
                            so.get().getaddress(showAddressBeans);

                    }
                });
    }
    @Override
    public void attch(addressview view) {
        so=new SoftReference<addressview>(view);
    }

    @Override
    public void dettch() {
        so.clear();
    }
}
