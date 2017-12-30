package com.example.sixseconddemo.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.sixseconddemo.bean.OrderBean;
import com.example.sixseconddemo.model.IOrderModel;
import com.example.sixseconddemo.model.OrderModel;

import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 郭金龙 on 2017/12/25.
 */

public class OrderPresenter implements IPresenter {
    String flag="";
    public IOrderModel model;
    Context context;
    public OrderPresenter(Context context){
        this.context=context;
        model=new OrderModel();
    }
    public void showOrder(Map map){
       model.setOrder().getOrder(map).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
               .subscribe(new Observer<OrderBean>() {
                   @Override
                   public void onCompleted() {

                   }

                   @Override
                   public void onError(Throwable e) {
                       Toast.makeText(context, "订单生成失败", Toast.LENGTH_SHORT).show();

                   }

                   @Override
                   public void onNext(OrderBean orderBean) {
                       Toast.makeText(context, "订单生成成功", Toast.LENGTH_SHORT).show();

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
