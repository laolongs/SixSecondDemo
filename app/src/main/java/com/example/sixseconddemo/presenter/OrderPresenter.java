package com.example.sixseconddemo.presenter;

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
    public IOrderModel model;
    public OrderPresenter(){
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

                   }

                   @Override
                   public void onNext(OrderBean orderBean) {

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
