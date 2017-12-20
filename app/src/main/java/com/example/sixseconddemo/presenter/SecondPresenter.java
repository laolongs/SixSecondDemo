package com.example.sixseconddemo.presenter;

import com.example.sixseconddemo.bean.BestSellerBean;
import com.example.sixseconddemo.model.ISecondModel;
import com.example.sixseconddemo.model.SecondModel;
import com.example.sixseconddemo.view.SecondView;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李倩 on 2017/12/20.
 */

public class SecondPresenter implements IPresenter<SecondView>{
    SoftReference<SecondView> so;
    ISecondModel model;
    public SecondPresenter(SecondView view) {
        attch(view);
        model=new SecondModel();
    }
    public void showBestscond(){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("curPage",1);
        map.put("pageSize",10);
        model.getsencond().getBeat(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BestSellerBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BestSellerBean bestSellerBean) {
                        List<BestSellerBean.ListBean> list=bestSellerBean.getList();
                        so.get().showSecond(list);
                    }
                });
    }
    @Override
    public void attch(SecondView view) {
        so=new SoftReference<SecondView>(view);
    }

    @Override
    public void dettch() {
        so.clear();

    }
}
