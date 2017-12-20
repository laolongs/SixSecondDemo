package com.example.sixseconddemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.BestSellerBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 李倩 on 2017/12/20.
 */

public class SecodenRecyAdapter extends RecyclerView.Adapter<SecodenRecyAdapter.ViewHolder>{
    Context context;
    List<BestSellerBean.ListBean> slist;

    public SecodenRecyAdapter(Context context, List<BestSellerBean.ListBean> slist) {
        this.context = context;
        this.slist = slist;
    }
    @Override
    public SecodenRecyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.second_item,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SecodenRecyAdapter.ViewHolder holder, int position) {
        holder.tv_title.setText(slist.get(position).getName());
        holder.tv_price.setText("￥"+slist.get(position).getPrice());
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(slist.get(position).getImgUrl()))
                .build();
        holder.sim.setController(controller);


    }

    @Override
    public int getItemCount() {
        return slist==null?0:slist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title,tv_price;
        Button btn_gm;
        SimpleDraweeView sim;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_price=itemView.findViewById(R.id.tv_price);
            sim=itemView.findViewById(R.id.sim);
            btn_gm=itemView.findViewById(R.id.btn_gm);

        }
    }
}
