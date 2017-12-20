package com.example.sixseconddemo.presenter;

import android.util.Log;

import com.example.sixseconddemo.bean.FenleiLeft;
import com.example.sixseconddemo.model.FenleiLefModel;
import com.example.sixseconddemo.model.IFenleiLeftModel;
import com.example.sixseconddemo.view.FenleiLeftView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李倩 on 2017/12/20.
 */

public class FenleiLefPresenter implements IPresenter<FenleiLeftView>{
    SoftReference<FenleiLeftView> so;
    IFenleiLeftModel model;
    List<FenleiLeft> list=new ArrayList<>();
    public FenleiLefPresenter(FenleiLeftView view) {
        attch(view);
        model=new FenleiLefModel();
    }
    public void getShowLeft(){
        model.getfenlei().getleft()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<FenleiLeft>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("-----111------", "onNext: "+e.getMessage());
                    }

                    @Override
                    public void onNext(List<FenleiLeft> fenleiLefts) {
                        Log.i("------111-----", "onNext: "+fenleiLefts.size());
                        so.get().showFeiLeft(fenleiLefts);
                    }
                });
    }
    @Override
    public void attch(FenleiLeftView view) {
        so=new SoftReference<FenleiLeftView>(view);

    }

    @Override
    public void dettch() {
        so.clear();
    }
}
