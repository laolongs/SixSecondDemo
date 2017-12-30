package com.example.sixseconddemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.presenter.UpdateDressPresenter;
import com.example.sixseconddemo.view.IupdateAddressView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpdateAddressActivity extends BaseActivity<UpdateDressPresenter> implements IupdateAddressView {

    @BindView(R.id.fifth_head_fh)
    ImageView fifthHeadFh;
    @BindView(R.id.fouth_head_gw)
    TextView fouthHeadGw;
    @BindView(R.id.save)
    TextView save;
    @BindView(R.id.etname)
    EditText etname;
    @BindView(R.id.etphone)
    EditText etphone;
    @BindView(R.id.etdress)
    EditText etdress;
    @BindView(R.id.ets)
    EditText ets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);
        ButterKnife.bind(this);
        fifthHeadFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onClick-----", "onClick: ");
                finish();
            }
        });

    }

    @Override
    public void createPresenter() {

    }

    @Override
    public int getid() {
        return 0;
    }

    @Override
    public String getconsignee() {
        return null;
    }

    @Override
    public String getphone() {
        return null;
    }

    @Override
    public String getaddr() {
        return null;
    }

    @Override
    public String getzip_code() {
        return null;
    }

    @Override
    public Boolean getdefault() {
        return null;
    }
}
