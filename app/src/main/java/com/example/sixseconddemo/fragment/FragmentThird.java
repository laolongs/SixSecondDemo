package com.example.sixseconddemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.sixseconddemo.R;
import com.example.sixseconddemo.activity.BaseFragment;
import com.example.sixseconddemo.adapter.LeftAdapter;
import com.example.sixseconddemo.adapter.Lv_RT_adapter;
import com.example.sixseconddemo.bean.FenLeiRight;
import com.example.sixseconddemo.bean.FenleiLeft;
import com.example.sixseconddemo.presenter.FenleiLefPresenter;
import com.example.sixseconddemo.view.FenleiLeftView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 郭金龙 on 2017/12/19.
 */

public class FragmentThird extends BaseFragment<FenleiLefPresenter> implements FenleiLeftView, XBanner.XBannerAdapter{
    private View view;
    Unbinder unbinder;
    @BindView(R.id.lv_left)
    ListView lv_left;
    Banner banner;
    private List<String> imgesUrl;
    private List<String> wenzi;
    private XBanner mXBanner;
    XRecyclerView xRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = View.inflate(getActivity(), R.layout.fragthird,null);
        unbinder = ButterKnife.bind(this, view);
        initBanner();
        xRecyclerView=view.findViewById(R.id.xrecyclerview);
        mXBanner.setmAdapter(this);
        presenter.getShowLeft();
        return view;
    }
    //放轮播数据的集合
    private void initBanner() {
        mXBanner = view.findViewById(R.id.xBanner);

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
        mXBanner.setData(imgesUrl, wenzi);
        mXBanner.setmAutoPalyTime(2000);
        mXBanner.setPageTransformer(Transformer.Rotate);    //立体旋转
        mXBanner.setPageChangeDuration(1500);
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
    public void showFeiLeft(final List<FenleiLeft> flist) {
        LeftAdapter adapter=new LeftAdapter(getActivity(),flist);
        lv_left.setAdapter(adapter);
        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.showright(flist.get(position).getId());
            }
        });

    }

    @Override
    public void showFeiRight(FenLeiRight rlist) {
        Log.i("-------------", "showFeiRight: "+rlist);
        GridLayoutManager mar=new GridLayoutManager(getActivity(),2);
        xRecyclerView.setLayoutManager(mar);
        Lv_RT_adapter adapter=new Lv_RT_adapter(getActivity(),rlist);
        xRecyclerView.setAdapter(adapter);
       


    }

    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(getActivity()).load(imgesUrl.get(position)).into((ImageView) view);
    }
}
