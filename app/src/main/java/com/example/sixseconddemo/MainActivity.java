package com.example.sixseconddemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.sixseconddemo.fragment.FragmentFifth;
import com.example.sixseconddemo.fragment.FragmentFirst;
import com.example.sixseconddemo.fragment.FragmentFouth;
import com.example.sixseconddemo.fragment.FragmentSecond;
import com.example.sixseconddemo.fragment.FragmentThird;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("主页",R.drawable.rgclick1, FragmentFirst.class)
                .addTabItem("热卖",R.drawable.rgclick2, FragmentSecond.class)
                .addTabItem("分类",R.drawable.rgclick3, FragmentThird.class)
                .addTabItem("购物车",R.drawable.rgclick4, FragmentFouth.class)
                .addTabItem("我的",R.drawable.rgclick5, FragmentFifth.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }
}
