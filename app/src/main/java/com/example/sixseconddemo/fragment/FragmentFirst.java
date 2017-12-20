package com.example.sixseconddemo.fragment;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.LunboBean;
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
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.xBanner)
    XBanner xBanner;
    Unbinder unbinder;
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
        xBanner.setmAdapter(this);

        //初始化XBanner轮播图
        initBanner();
        return view;
    }
    //自动生成View里面的方法
    @Override
    public void setBanner(LunboBean lunboBean) {
        presenter.showBanner(lunboBean.getId() + "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
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
        xBanner.setData(imgesUrl,wenzi);
        xBanner.setPageTransformer(Transformer.Default);
    }
    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(getActivity()).load(imgesUrl.get(position)).into((ImageView) view);
    }
}
