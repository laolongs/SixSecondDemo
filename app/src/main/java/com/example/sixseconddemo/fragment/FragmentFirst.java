package com.example.sixseconddemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sixseconddemo.R;
import com.example.sixseconddemo.activity.SousuoActivity;
import com.example.sixseconddemo.adapter.MyShowAdaoer;
import com.example.sixseconddemo.bean.ShouyeBean;
import com.example.sixseconddemo.presenter.FirstPresenter;
import com.example.sixseconddemo.view.IFifstView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by 郭金龙 on 2017/12/19.
 */

public class FragmentFirst extends Fragment implements IFifstView, XBanner.XBannerAdapter {

    //使用依赖注入实现
    @BindView(R.id.xBanner)
    XBanner xBanner;
    Unbinder unbinder;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.rv)
    RecyclerView rv;
    private View view;
    private FirstPresenter presenter;
    private List<String> imgesUrl;
    private List<String> wenzi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragfirst, null);
        unbinder = ButterKnife.bind(this, view);
        presenter = new FirstPresenter(this);
        presenter.showRV();
        xBanner.setmAdapter(this);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        //初始化XBanner轮播图
        initBanner();
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SousuoActivity.class));
            }
        });
        return view;
    }

    //自动生成View里面的方法
    @Override
    public void setJiazai(List<ShouyeBean> Bean) {
        MyShowAdaoer adaoer = new MyShowAdaoer(getActivity(), Bean);
        rv.setAdapter(adaoer);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //放轮播数据的集合
    private void initBanner() {
        //直接加图片的xbanner
        wenzi = new ArrayList<>();
        imgesUrl = new ArrayList<>();
        wenzi.add("音箱狂欢");
        wenzi.add("手机国庆礼");
        wenzi.add("IT生活");
        wenzi.add("母婴萌宝");
        wenzi.add("国庆大礼包");
        wenzi.add("手机大放假");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608f3b5Nc8d90151.jpg");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608eb8cN9b9a0a39.jpg");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608cae6Nbb1a39f9.jpg");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/5608b7cdN218fb48f.jpg");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/560b5a7eN214306c8.jpg");
        imgesUrl.add("http://7mno4h.com2.z0.glb.qiniucdn.com/560a409eN35e252de.jpg");
        xBanner.setData(imgesUrl, wenzi);
        xBanner.setmAutoPalyTime(2000);
        xBanner.setPageTransformer(Transformer.Rotate);    //立体旋转
        xBanner.setPageChangeDuration(1500);
    }

    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(getActivity()).load(imgesUrl.get(position)).into((ImageView) view);
    }


}
