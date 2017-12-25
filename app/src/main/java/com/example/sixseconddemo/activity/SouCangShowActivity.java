package com.example.sixseconddemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.adapter.SCshow_adapter;
import com.example.sixseconddemo.bean.SoucangBean;
import com.example.sixseconddemo.presenter.SCshowPresenter;
import com.example.sixseconddemo.view.ISCshowView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SouCangShowActivity extends AppCompatActivity implements ISCshowView {

    @BindView(R.id.rv2)
    RecyclerView rv2;
    private SCshowPresenter sCshowPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_cang_show);
        ButterKnife.bind(this);

        sCshowPresenter = new SCshowPresenter(this,this);
        sCshowPresenter.showSC();
        rv2.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setJiazai(List<SoucangBean> Bean) {
        SCshow_adapter adapter=new SCshow_adapter(SouCangShowActivity.this,Bean);

        rv2.setAdapter(adapter);
    }
}
