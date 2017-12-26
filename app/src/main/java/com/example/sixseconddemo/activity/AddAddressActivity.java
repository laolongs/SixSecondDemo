package com.example.sixseconddemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.presenter.AddDressPresenter;
import com.example.sixseconddemo.view.IaddAddressView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddAddressActivity extends BaseActivity<AddDressPresenter> implements IaddAddressView {

    @BindView(R.id.fifth_head_fh)
    ImageView fifthHeadFh;
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
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addDress();
//                EventAddressCheck addressCheck=new EventAddressCheck();
//                addressCheck.setCheck(true);
//                EventBus.getDefault().post(addressCheck);
            }
        });
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
        presenter = new AddDressPresenter(this, this);
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
}
