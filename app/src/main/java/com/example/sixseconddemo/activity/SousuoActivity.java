package com.example.sixseconddemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sixseconddemo.R;

public class SousuoActivity extends Activity {

    private ImageView ss_ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);
        final EditText sousuo= (EditText) findViewById(R.id.editText_ss);

        ss_ss = (ImageView) findViewById(R.id.ss_ss);
        ss_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SousuoActivity.this,SousuoXiangqingActivity.class);
                if(TextUtils.isEmpty(sousuo.getText().toString()))
                {
                    Toast.makeText(SousuoActivity.this,"请输入您要搜索的商品",Toast.LENGTH_SHORT).show();
                }else {
                    intent.putExtra("name",sousuo.getText().toString());
                    startActivity(intent);
                }

            }
        });
        findViewById(R.id.jt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
