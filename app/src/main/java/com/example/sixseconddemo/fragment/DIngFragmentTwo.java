package com.example.sixseconddemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.activity.BaseFragment;
import com.example.sixseconddemo.adapter.MyDingOneAdapter;
import com.example.sixseconddemo.base.Base;
import com.example.sixseconddemo.bean.OrderlistBean;
import com.example.sixseconddemo.presenter.OrderListPresenter;
import com.example.sixseconddemo.utils.SharedUtil;
import com.example.sixseconddemo.view.IOrderListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 郭金龙 on 2017/12/29.
 */

public class DIngFragmentTwo extends BaseFragment<OrderListPresenter> implements IOrderListView {
    @BindView(R.id.ding_one_rl)
    LinearLayout dingOneRl;
    @BindView(R.id.ding_one_rcl)
    RecyclerView dingOneRcl;
    Unbinder unbinder;
    List<OrderlistBean.ItemsBean> list=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = View.inflate(getActivity(), R.layout.ding_fragment_one, null);
        String userid = (String) SharedUtil.getInstances().getValueByKey(getActivity(), "userid", "");
        int status = 0;
        String token = Base.TOKEN;
        presenter.showOrderList(userid, status, token);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void createPresenter() {
        presenter = new OrderListPresenter(this);
    }

    @Override
    public void setOrderListView(List<OrderlistBean> bean) {
//        List<OrderlistBean.ItemsBean> list=  bean;
        for (int i = 0; i < bean.size(); i++) {
            for (int j = 0; j < bean.get(i).getItems().size(); j++) {
                list.add(bean.get(i).getItems().get(j));
            }
        }
        Log.i("------setOrderLi-", "setOrderListView: "+bean.size());
        if(bean!=null){
            dingOneRl.setVisibility(View.GONE);
            dingOneRcl.setLayoutManager(new LinearLayoutManager(getActivity()));
            MyDingOneAdapter adapter=new MyDingOneAdapter(list,getActivity());
            dingOneRcl.setAdapter(adapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
