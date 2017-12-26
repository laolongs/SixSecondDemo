package com.example.sixseconddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.CarBean;
import com.example.sixseconddemo.bean.showAddressBean;
import com.example.sixseconddemo.dao.AddDao;
import com.example.sixseconddemo.dao.CarDao;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 郭金龙 on 2017/12/25.
 */

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEAD = 0;
    public static final int TYPE_MAIN = 1;
    public static final int TYPE_FOOT = 2;
    List<View> listhead = new ArrayList<>();
    List<View> listfoot = new ArrayList<>();
    String isDefault="1";
    List<showAddressBean> queryadd;
    Context context;
    CarDao dao;
    AddDao addDao;
    String flag = "1";
    List<CarBean> list;



    public void addHead(View view) {
        listhead.add(view);
    }

    public void addFoot(View view) {
        listfoot.add(view);
    }

    public OrderAdapter(Context context) {
        this.context = context;
        dao = new CarDao(context);
        addDao=new AddDao(context);
    }

    public void getorderData() {
        List<CarBean> query = dao.query(flag);
        List<showAddressBean> queryadd = addDao.queryadd(isDefault);
        this.list = query;
        this.queryadd=queryadd;
        Log.i("----queryadd.size----", "getItemCount: " + queryadd.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            View view = View.inflate(context, R.layout.fouth_order_head, null);
            return new HeadViewHolder(view);
        } else if (viewType == TYPE_MAIN) {
            View view = View.inflate(context, R.layout.fouth_order_item, null);
            return new MainViewHolder(view);
        } else {
            View view = View.inflate(context, R.layout.fouth_order_foot, null);
            return new FootViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeadViewHolder) {
            ((HeadViewHolder)holder).orderMainShouhuo.setText("收货人："+queryadd.get(position).getConsignee());
            ((HeadViewHolder)holder).orderMainPhone.setText("电话："+queryadd.get(position).getPhone());
            ((HeadViewHolder)holder).orderMainAddress.setText("收货地址："+queryadd.get(position).getAddr());
        }
        if (holder instanceof MainViewHolder) {
            ((MainViewHolder) holder).orderMainTitle.setText(list.get(position - listhead.size()).getTitle());
            DraweeController build = Fresco.newDraweeControllerBuilder().setUri(list.get(position - listhead.size()).getImg()).build();
            ((MainViewHolder) holder).orderMainSdv.setController(build);
            ((MainViewHolder) holder).orderMainPrice.setText("￥" + list.get(position - listhead.size()).getPrice());
//            ((MainViewHolder) holder).orderMainNums.setText("1");
            ((MainViewHolder) holder).orderMainPrices.setText("￥" + list.get(position - listhead.size()).getPrice());
        }
        if (holder instanceof FootViewHolder) {

        }
    }
    public String getPrice(){
        int price=0;
        for (int i = 0; i < list.size(); i++) {
            CarBean bean = list.get(i);
            price+= Double.parseDouble(bean.getPrice());
        }
        return price+"";
    }

    @Override
    public int getItemCount() {
        Log.i("----order.size--------", "getItemCount: " + list.size());
        return list == null ? 0 : list.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < listhead.size()) {
            return TYPE_HEAD;
        } else if (position >= list.size() + listhead.size()) {
            return TYPE_FOOT;
        } else {
            return TYPE_MAIN;
        }

    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.order_main_sdv)
        SimpleDraweeView orderMainSdv;
        @BindView(R.id.order_main_title)
        TextView orderMainTitle;
        @BindView(R.id.order_main_price)
        TextView orderMainPrice;
        @BindView(R.id.order_main_num)
        TextView orderMainNum;
        @BindView(R.id.order_main_nums)
        TextView orderMainNums;
        @BindView(R.id.order_main_prices)
        TextView orderMainPrices;
        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class HeadViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.order_main_img)
        ImageView orderMainImg;
        @BindView(R.id.order_main_shouhuo)
        TextView orderMainShouhuo;
        @BindView(R.id.order_main_phone)
        TextView orderMainPhone;
        @BindView(R.id.order_main_address)
        TextView orderMainAddress;
        @BindView(R.id.order_main_head)
        LinearLayout orderMainHead;

        public HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class FootViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.order_main_foot_ck)
        CheckBox orderMainFootCk;

        public FootViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
