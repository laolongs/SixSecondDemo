package com.example.sixseconddemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.activity.BaseFragment;
import com.example.sixseconddemo.adapter.LeftAdapter;
import com.example.sixseconddemo.bean.FenLeiRight;
import com.example.sixseconddemo.bean.FenleiLeft;
import com.example.sixseconddemo.presenter.FenleiLefPresenter;
import com.example.sixseconddemo.view.FenleiLeftView;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 郭金龙 on 2017/12/19.
 */

public class FragmentThird extends BaseFragment<FenleiLefPresenter> implements FenleiLeftView{
    private View view;
    Unbinder unbinder;
    @BindView(R.id.lv_left)
    ListView lv_left;
    Banner banner;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = View.inflate(getActivity(), R.layout.fragthird,null);
        unbinder = ButterKnife.bind(this, view);

        initview();
        presenter.getShowLeft();
        return view;
    }

    private void initview() {
        banner= view.findViewById(R.id.banner);
    }

    @Override
    public void createPresenter() {
    presenter=new FenleiLefPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showFeiLeft(List<FenleiLeft> flist) {
        LeftAdapter adapter=new LeftAdapter(getActivity(),flist);
        lv_left.setAdapter(adapter);
    }

    @Override
    public void showFeiRight(List<FenLeiRight> rlist) {

    }

}
