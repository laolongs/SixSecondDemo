package com.example.sixseconddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.OrderlistBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 郭金龙 on 2017/12/29.
 */

public class MyDingOneAdapter extends RecyclerView.Adapter<MyDingOneAdapter.ViewHolder> {

    List<OrderlistBean.ItemsBean> list;
    Context context;


    public MyDingOneAdapter(List<OrderlistBean.ItemsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.ding_one_item, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DraweeController build = Fresco.newDraweeControllerBuilder().setUri(list.get(position).getWares().getImgUrl()).build();
        holder.dingOneSdv.setController(build);
        holder.dingOneTitle.setText(list.get(position).getWares().getName());
        holder.dingOnePrice.setText(list.get(position).getWares().getPrice()+"");
        holder.dingPrices.setText(list.get(position).getWares().getPrice()+"");
    }

    @Override
    public int getItemCount() {
        Log.i("----getItemCount----", "getItemCount: "+list.size());
        return list == null ? 0 : list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ding_one_sdv)
        SimpleDraweeView dingOneSdv;
        @BindView(R.id.ding_one_title)
        TextView dingOneTitle;
        @BindView(R.id.ding_one_price)
        TextView dingOnePrice;
        @BindView(R.id.ding_one_num)
        TextView dingOneNum;
        @BindView(R.id.ding_nums)
        TextView dingNums;
        @BindView(R.id.ding_prices)
        TextView dingPrices;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
