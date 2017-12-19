package com.example.sixseconddemo.presenter;

/**
 * Created by 郭金龙 on 2017/12/19.
 */

public interface IPresenter<T> {
    public void attch(T view);
    public void dettch();
}