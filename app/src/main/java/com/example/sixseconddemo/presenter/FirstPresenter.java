package com.example.sixseconddemo.presenter;

import com.example.sixseconddemo.bean.LunboBean;
import com.example.sixseconddemo.bean.ShouyeBean;
import com.example.sixseconddemo.model.IshouyeModel;
import com.example.sixseconddemo.model.ShouyeModel;
import com.example.sixseconddemo.view.IFifstView;

import java.lang.ref.SoftReference;
import java.util.List;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by one Dream on 2017/12/20.
 */

public class FirstPresenter implements IPresenter<IFifstView>{
    SoftReference<IFifstView> reference;
    IshouyeModel model;
    public FirstPresenter(IFifstView view){
        attch(view);
        model=new ShouyeModel();
    }
    public void showRV(){
       model.Shuju().getJiazai().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<List<ShouyeBean>>() {
           @Override
           public void onCompleted() {

           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onNext(List<ShouyeBean> shouyeBeans) {
               reference.get().setJiazai(shouyeBeans);

           }
       });
    }
    @Override
    public void attch(IFifstView view) {
        reference=new SoftReference<IFifstView>(view);
    }

    @Override
    public void dettch() {

    }
}
