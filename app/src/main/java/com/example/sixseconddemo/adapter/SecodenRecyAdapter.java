package com.example.sixseconddemo.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.BestSellerBean;
import com.example.sixseconddemo.bean.EventPass;
import com.example.sixseconddemo.dao.CarDao;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 李倩 on 2017/12/20.
 */

public class SecodenRecyAdapter extends RecyclerView.Adapter<SecodenRecyAdapter.ViewHolder>{
    Context context;
    List<BestSellerBean.ListBean> slist;
    CarDao dao;
    Lv_RT_adapter.OnItemClickListener listener;
    public void  setOnItemClickListener(Lv_RT_adapter.OnItemClickListener listener) {
        this.listener = listener;
    }
    public SecodenRecyAdapter(Context context, List<BestSellerBean.ListBean> slist) {
        this.context = context;
        this.slist = slist;
        dao=new CarDao(context);
    }
    @Override
    public SecodenRecyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.second_item,null);
        ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.onItemClick((Integer) view.getTag());
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final SecodenRecyAdapter.ViewHolder holder, final int position) {
        holder.tv_title.setText(slist.get(position).getName());
        holder.tv_price.setText("￥"+slist.get(position).getPrice());
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(slist.get(position).getImgUrl()))
                .build();
        holder.sim.setController(controller);
        holder.itemView.setTag(position);
        holder.btn_gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values=new ContentValues();
                values.put("userid",slist.get(position).getId());
                values.put("title", slist.get(position).getName());
                values.put("img",slist.get(position).getImgUrl());
                values.put("price",slist.get(position).getPrice());
                dao.insert(values);
                Toast.makeText(context,"加入购物车成功",Toast.LENGTH_SHORT).show();
                EventPass pass=new EventPass();
                pass.setChecked(true);
                EventBus.getDefault().post(pass);

            }
        });

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
    public  interface  OnItemClickListener{
        public  void onItemClick(int position);
    }

}
