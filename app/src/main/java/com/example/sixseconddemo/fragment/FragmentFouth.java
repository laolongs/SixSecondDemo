package com.example.sixseconddemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.adapter.CarAdatper;
import com.example.sixseconddemo.bean.EventCheck;
import com.example.sixseconddemo.bean.EventPass;
import com.example.sixseconddemo.bean.EventPriceAndNum;
import com.example.sixseconddemo.utils.SharedUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 郭金龙 on 2017/12/19.
 */

public class FragmentFouth extends Fragment {
    @BindView(R.id.fouth_head_fh)
    ImageView fouthHeadFh;
    @BindView(R.id.fouth_head_gw)
    TextView fouthHeadGw;
    @BindView(R.id.fouth_head_bj)
    TextView fouthHeadBj;
    @BindView(R.id.searchedit_header)
    LinearLayout searcheditHeader;
    @BindView(R.id.fouth_recy)
    RecyclerView fouthRecy;
    @BindView(R.id.fouth_foot_ck)
    CheckBox fouthFootCk;
    @BindView(R.id.fouth_foot_hj)
    TextView fouthFootHj;
    @BindView(R.id.fouth_foot_js)
    TextView fouthFootJs;
    @BindView(R.id.searchedit_foot)
    LinearLayout searcheditFoot;
    Unbinder unbinder;
    private View view;
    public CarAdatper adatper;
    int count=0;
    private String userid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragfouth, null);
        EventBus.getDefault().register(this);
        unbinder = ButterKnife.bind(this, view);
        userid = (String) SharedUtil.getInstances().getValueByKey(getActivity(), "userid", "");
        initData();
        initConfig();
        return view;
    }

    private void initConfig() {
        fouthHeadBj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    fouthHeadBj.setText("完成");
                    fouthFootJs.setText("删除");
                }else{
                    fouthHeadBj.setText("编辑");
                    fouthFootJs.setText("去结算");
                }
            }
        });
        fouthFootCk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatper.changAllListCbState(fouthFootCk.isChecked());
                adatper.notifyDataSetChanged();
            }
        });
        fouthFootJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fouthFootJs.getText().toString();

                if(name.equals("去结算")){
                    if(userid!=null){
                        adatper.select();
                    }else{
                        Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                    }
                }
                if(name.equals("删除")){
                            adatper.delete();
                }
            }
        });
    }

    private void initData() {
        adatper=new CarAdatper(getActivity());
        fouthRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        fouthRecy.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        fouthRecy.setAdapter(adatper);
        adatper.getData();
        adatper.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void EventBusData(EventCheck check) {
        fouthFootCk.setChecked(check.isChecked());
    }

    @Subscribe
    public void EventBusData(EventPriceAndNum priceAndNum) {
        fouthFootHj.setText("合计：￥"+priceAndNum.getPrice());
    }
    @Subscribe
    public void EventBusData(EventPass pass) {
       if(pass.isChecked()){
           adatper.getData();
           adatper.notifyDataSetChanged();
       }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
