package com.example.sixseconddemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.adapter.OrderAdapter;
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
    private OrderAdapter adapter;

    //   user_id 279643
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        initfirst();
//        initData();

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
        orderFootHj.setText("合计："+adapter.getPrice());
    }

    private void initData() {

        long userid = (long) SharedUtil.getInstances().getValueByKey(this, "userid", null);
        String itemjson = "";
        int price = 0;
        long addrid = 0;
        String PAY = "alipay";
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userid);
        map.put("item_json", itemjson);
        map.put("amount", price);
        map.put("addr_id", addrid);
        map.put("pay_channel", PAY);
        presenter.showOrder(map);
    }

    @Override
    public void createPresenter() {
        presenter = new OrderPresenter();
    }
}
