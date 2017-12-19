package com.example.sixseconddemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sixseconddemo.presenter.IPresenter;

/**
 * Created by 郭金龙 on 2017/11/15.
 */

public abstract class BaseActivity<T extends IPresenter> extends AppCompatActivity {
   public T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
    }
    public abstract void createPresenter();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettch();
    }
}
