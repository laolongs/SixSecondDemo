package com.example.sixseconddemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sixseconddemo.R;

/**
 * Created by 郭金龙 on 2017/12/19.
 */

public class FragmentSecond extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragsecond,null);
        Toast.makeText(getActivity(),"aaa",Toast.LENGTH_LONG).show();
        return view;
    }
}
