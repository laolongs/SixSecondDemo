package com.example.sixseconddemo.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.dao.CarDao;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class XQActivity extends AppCompatActivity {
    TextView xq_tv_title,xq_tv_price;
    Button xq_btn_car,xq_btn_gm,xq_sc;
    SimpleDraweeView sidm;
    CarDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq);
        initview();
         dao=new CarDao(this);

    }
    private void initview() {
        xq_tv_title= findViewById(R.id.xq_tv_title);
        xq_tv_price= findViewById(R.id.xq_tv_price);
        xq_btn_car= findViewById(R.id.xq_btn_car);
        xq_btn_gm= findViewById(R.id.xq_btn_gm);
        xq_sc=findViewById(R.id.xq_sc);
        sidm=findViewById(R.id.simD);
        Intent intent=getIntent();
        final   int id = intent.getIntExtra("id",0);
        final String title = intent.getStringExtra("title");
        final Double price = intent.getDoubleExtra("price",0);
        final String img = intent.getStringExtra("img");
        xq_tv_title.setText(title);
        xq_tv_price.setText("￥"+price);
        DraweeController controller= Fresco.newDraweeControllerBuilder()
              .setUri(img)
              .build();
        sidm.setController(controller);
        xq_btn_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values=new ContentValues();
                values.put("title",title);
                values.put("img",img);
                values.put("price",price);
                dao.insert(values);
                Toast.makeText(XQActivity.this,"加入购物车成功",Toast.LENGTH_SHORT).show();
            }
        });


        xq_btn_gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values=new ContentValues();
                values.put("title",title);
                values.put("img",img);
                values.put("price",price);
                dao.insert(values);
                Toast.makeText(XQActivity.this,"加入购物车成功",Toast.LENGTH_SHORT).show();

            }
        });
        xq_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
