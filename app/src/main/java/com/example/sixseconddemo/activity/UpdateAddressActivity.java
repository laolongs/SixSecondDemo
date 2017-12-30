package com.example.sixseconddemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    @BindView(R.id.cbitem)
    CheckBox cbitem;
    private int id;
    private String ischecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);
        ButterKnife.bind(this);
        id = Integer.parseInt(getIntent().getStringExtra("id"));
        String addr = getIntent().getStringExtra("addr");
        String consignee = getIntent().getStringExtra("consignee");
        ischecked = getIntent().getStringExtra("ischecked");
        Log.i("----ischecked+++", "onCreate: "+ischecked);
        String phone = getIntent().getStringExtra("phone");
        String zipCode = getIntent().getStringExtra("zipCode");
        etname.setText(consignee);
        etphone.setText(phone);
        ets.setText(zipCode);
        etdress.setText(addr);

        fifthHeadFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onClick-----", "onClick: ");
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getupdate();
            }
        });
//        if(ischecked.equals("true")){
//            cbitem.isChecked();
//        }
        cbitem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ischecked="true";
                }else{
                    ischecked="false";
                }
            }
        });

    }

    @Override
    public void createPresenter() {
        presenter = new UpdateDressPresenter(this, this);
    }

    @Override
    public int getid() {
        return id;
    }

    @Override
    public String getconsignee() {
        return etname.getText().toString();
    }

    @Override
    public String getphone() {
        return etphone.getText().toString();
    }

    @Override
    public String getaddr() {
        return etdress.getText().toString();
    }

    @Override
    public String getzip_code() {
        return ets.getText().toString();
    }

    @Override
    public Boolean getdefault() {
        return Boolean.valueOf(ischecked);
    }
}
