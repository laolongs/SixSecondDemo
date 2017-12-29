package com.example.sixseconddemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.adapter.MyDingAdapter;
import com.example.sixseconddemo.fragment.DIngFragmentFive;
import com.example.sixseconddemo.fragment.DIngFragmentFour;
import com.example.sixseconddemo.fragment.DIngFragmentOne;
import com.example.sixseconddemo.fragment.DIngFragmentThree;
import com.example.sixseconddemo.fragment.DIngFragmentTwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDingDanActivity extends AppCompatActivity {

    @BindView(R.id.ding_head_tv)
    TextView dingHeadTv;
    @BindView(R.id.ding_tab)
    TabLayout dingTab;
    @BindView(R.id.ding_vp)
    ViewPager dingVp;
    String[] arraytb=new String[]{"全部","待付款","待发货","待收货","待评价"};
    List<Fragment> listFragment=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ding_dan);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        listFragment.add(new DIngFragmentOne());
        listFragment.add(new DIngFragmentTwo());
        listFragment.add(new DIngFragmentThree());
        listFragment.add(new DIngFragmentFour());
        listFragment.add(new DIngFragmentFive());
        dingHeadTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                return;
            }
        });
        MyDingAdapter adapter=new MyDingAdapter(getSupportFragmentManager(),listFragment,arraytb);
        dingVp.setAdapter(adapter);
        dingTab.setupWithViewPager(dingVp);
    }
}
