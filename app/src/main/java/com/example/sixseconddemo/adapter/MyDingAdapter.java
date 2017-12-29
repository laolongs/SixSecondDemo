package com.example.sixseconddemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 郭金龙 on 2017/12/29.
 */

public class MyDingAdapter extends FragmentPagerAdapter {
    List<Fragment> list;
    String[] listtab;
    public MyDingAdapter(FragmentManager fm, List<Fragment> list,String[] listtab) {
        super(fm);
        this.list=list;
        this.listtab=listtab;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listtab[position];
    }
}
