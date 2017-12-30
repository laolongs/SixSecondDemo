package com.example.sixseconddemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sixseconddemo.R;

/**
 * Created by 郭金龙 on 2017/12/29.
 */

public class DIngFragmentThree extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = View.inflate(getActivity(), R.layout.ding_fragment_one, null);
        return view;
    }
}
