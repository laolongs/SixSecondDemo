package com.example.sixseconddemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.activity.BaseFragment;
import com.example.sixseconddemo.adapter.SecodenRecyAdapter;
import com.example.sixseconddemo.bean.BestSellerBean;
import com.example.sixseconddemo.presenter.SecondPresenter;
import com.example.sixseconddemo.view.SecondView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 郭金龙 on 2017/12/19.
 */

public class FragmentSecond extends BaseFragment<SecondPresenter>implements SecondView {
    private View view;
    Unbinder unbinder;
    @BindView(R.id.second_recy)
    RecyclerView second_recy;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = View.inflate(getActivity(), R.layout.fragsecond,null);
        unbinder = ButterKnife.bind(this, view);
        presenter.showBestscond();
        return view;
    }
    @Override
    public void createPresenter() {
        presenter=new SecondPresenter(this);

    }

    @Override
    public void showSecond(List<BestSellerBean.ListBean> slist) {
        LinearLayoutManager mar=new LinearLayoutManager(getActivity());
        second_recy.setLayoutManager(mar);
        SecodenRecyAdapter adapter=new SecodenRecyAdapter(getActivity(),slist);
        second_recy.setAdapter(adapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
