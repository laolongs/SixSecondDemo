package com.example.sixseconddemo.presenter;

import android.util.Log;

import com.example.sixseconddemo.bean.OrderlistBean;
import com.example.sixseconddemo.model.IOrderModelList;
import com.example.sixseconddemo.model.OrderModelList;
import com.example.sixseconddemo.view.IOrderListView;

import java.lang.ref.SoftReference;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 郭金龙 on 2017/12/25.
 */

public class OrderListPresenter implements IPresenter<IOrderListView> {
    SoftReference<IOrderListView> reference;
    public IOrderModelList model;
    public OrderListPresenter(IOrderListView view){
        attch(view);
        model=new OrderModelList();
    }
    public void showOrderList(String userid,int status,String token){
       model.serOrderList().getOrderList(userid,status,token)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<OrderlistBean>() {
                   @Override
                   public void onCompleted() {

                   }

                   @Override
                   public void onError(Throwable e) {
                       Log.i("----showOrderList-----", "onError: "+e.getMessage());
                   }

                   @Override
                   public void onNext(OrderlistBean orderlistBean) {
                        reference.get().setOrderListView(orderlistBean);
                   }
               });

    }
    @Override
    public void attch(IOrderListView view) {
        reference=new SoftReference<IOrderListView>(view);
    }

    @Override
    public void dettch() {
        reference.clear();
    }
}
