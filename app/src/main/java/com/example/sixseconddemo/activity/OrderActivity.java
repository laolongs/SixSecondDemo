package com.example.sixseconddemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.adapter.OrderAdapter;
import com.example.sixseconddemo.base.Base;
import com.example.sixseconddemo.presenter.OrderPresenter;
import com.example.sixseconddemo.utils.SharedUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderActivity extends BaseActivity<OrderPresenter> {


    @BindView(R.id.fouth_head_dd)
    TextView fouthHeadDd;
    @BindView(R.id.order_header)
    LinearLayout orderHeader;
    @BindView(R.id.order_recy)
    RecyclerView orderRecy;
    @BindView(R.id.order_foot_hj)
    TextView orderFootHj;
    @BindView(R.id.order_foot_commit)
    TextView orderFootCommit;
    @BindView(R.id.order_foot)
    LinearLayout orderFoot;
    @BindView(R.id.order_foot_pay)
    TextView orderFootPay;
    private OrderAdapter adapter;
    String s="";
    boolean flag=false;
    //   user_id 279643
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        initfirst();
        initData();

    }

    private void initfirst() {
        orderRecy.setLayoutManager(new LinearLayoutManager(this));
        View head = View.inflate(this, R.layout.fouth_order_head, null);
        View foot = View.inflate(this, R.layout.fouth_order_foot, null);
        adapter = new OrderAdapter(this);
        orderRecy.setAdapter(adapter);
        adapter.addHead(head);
        adapter.addFoot(foot);
        adapter.getorderData();
        adapter.notifyDataSetChanged();
        orderFootHj.setText("合计：" + adapter.getPrice());
    }

    private void initData() {
        String userid = (String) SharedUtil.getInstances().getValueByKey(this, "userid", "");
        long usid = Long.parseLong(userid);
        String carJson = adapter.getCarJson();
        int price = (int) adapter.getPrice();
        long addrid = adapter.getAddrid();
        String PAY = "alipay";
        final Map<String, Object> map = new HashMap<>();
        map.put("user_id", usid);
        map.put("item_json", carJson);
        map.put("amount", price);
        map.put("addr_id", addrid);
        map.put("pay_channel", PAY);
        map.put("token", Base.TOKEN);
        orderFootCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                presenter.showOrder(map);
            }
        });
        orderFootPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    Toast.makeText(OrderActivity.this, "开始支付", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(OrderActivity.this, "请先提交订单", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void createPresenter() {
        presenter = new OrderPresenter(this);
    }
}
