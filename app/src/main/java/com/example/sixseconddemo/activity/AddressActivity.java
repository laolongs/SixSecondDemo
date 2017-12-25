package com.example.sixseconddemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.adapter.AddressAdapter;
import com.example.sixseconddemo.bean.showAddressBean;
import com.example.sixseconddemo.presenter.AddressPresenter;
import com.example.sixseconddemo.utils.SimleDividerItemDecoration;
import com.example.sixseconddemo.view.addressview;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressActivity extends BaseActivity<AddressPresenter> implements addressview {

    @BindView(R.id.rvfifth)
    RecyclerView rvfifth;
    @BindView(R.id.rlbottom)
    RelativeLayout rlbottom;
    @BindView(R.id.fifth_head_fh)
    ImageView fifthHeadFh;
    private AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        presenter.showAddress();
        rlbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressActivity.this, AddAddressActivity.class);
                startActivity(intent);
            }
        });
        fifthHeadFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void createPresenter() {
        presenter = new AddressPresenter(this, this);
    }

    @Override
    public void getaddress(List<showAddressBean> listaddress) {
        Log.i("------getaddress------", "getaddress: ");
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvfifth.setLayoutManager(llm);
        addressAdapter = new AddressAdapter(AddressActivity.this, listaddress);
        rvfifth.setAdapter(addressAdapter);
        rvfifth.addItemDecoration(new SimleDividerItemDecoration(this));
    }
}
