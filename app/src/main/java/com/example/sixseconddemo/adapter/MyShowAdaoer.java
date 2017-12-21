package com.example.sixseconddemo.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sixseconddemo.R;
import com.example.sixseconddemo.activity.XiangqingActivity;
import com.example.sixseconddemo.bean.ShouyeBean;

import java.util.List;
import java.util.logging.Handler;

/**
 * Created by one Dream on 2017/12/20.
 */

public class MyShowAdaoer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ShouyeBean> shouyeBean;

    public MyShowAdaoer(Context context, List<ShouyeBean> shouyeBean) {
        this.context = context;
        this.shouyeBean = shouyeBean;
    }
    @Override
    public int getItemViewType(int position) {
        //跟据position对应的条目返回去对应的样式（Type）
        if (position%2== 1) {
            return 1;
        } else  {
            return 0;
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {
            View inflate = View.inflate(context, R.layout.first_item1,null);
            return new MyViewHolder(inflate);
        } else {
            View inflate = View.inflate(context, R.layout.first_item2,null);
            return new MyViewHolder2(inflate);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            final MyViewHolder myViewHolder = (MyViewHolder)holder;
            myViewHolder.title1.setText(shouyeBean.get(position).getTitle());
            Glide.with(context).load(shouyeBean.get(position).getCpOne().getImgUrl()).into(myViewHolder.item1_zuoimage);
            Glide.with(context).load(shouyeBean.get(position).getCpTwo().getImgUrl()).into(myViewHolder.item1_youimage);
            Glide.with(context).load(shouyeBean.get(position).getCpThree().getImgUrl()).into(myViewHolder.item1_youimage2);
            myViewHolder.item1_zuoimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ObjectAnimator animator =  ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
                            .setDuration(200);
                    animator.start();
                    context.startActivity(new Intent(context,XiangqingActivity.class));
                }
            });
            myViewHolder.item1_youimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ObjectAnimator animator =  ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
                            .setDuration(200);
                    animator.start();

                    context.startActivity(new Intent(context,XiangqingActivity.class));
                }
            });
            myViewHolder.item1_youimage2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ObjectAnimator animator =  ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
                            .setDuration(200);
                    animator.start();

                    context.startActivity(new Intent(context,XiangqingActivity.class));
                }
            });

        } else {
            final MyViewHolder2 myViewHolder = (MyViewHolder2)holder;
            myViewHolder.title2.setText(shouyeBean.get(position).getTitle());
            Glide.with(context).load(shouyeBean.get(position).getCpTwo().getImgUrl()).into(myViewHolder.item2_zuoimage);
            Glide.with(context).load(shouyeBean.get(position).getCpThree().getImgUrl()).into(myViewHolder.item2_zuoimage2);
            Glide.with(context).load(shouyeBean.get(position).getCpOne().getImgUrl()).into(myViewHolder.item2_youimage);
            myViewHolder.item2_zuoimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ObjectAnimator animator =  ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
                            .setDuration(200);
                    animator.start();

                    context.startActivity(new Intent(context,XiangqingActivity.class));
                }
            });
            myViewHolder.item2_zuoimage2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ObjectAnimator animator =  ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
                            .setDuration(200);
                    animator.start();

                    context.startActivity(new Intent(context,XiangqingActivity.class));
                }
            });
            myViewHolder.item2_youimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ObjectAnimator animator =  ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
                            .setDuration(200);
                    animator.start();

                    context.startActivity(new Intent(context,XiangqingActivity.class));
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return shouyeBean.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        private final ImageView item1_zuoimage;
        private final ImageView item1_youimage;
        private final ImageView item1_youimage2;
        private final TextView title1;

        public MyViewHolder(View itemView) {
            super(itemView);
            title1 = itemView.findViewById(R.id.title1);
            item1_zuoimage = itemView.findViewById(R.id.item1_zuoimage);
            item1_youimage = itemView.findViewById(R.id.item1_youimage);
            item1_youimage2 = itemView.findViewById(R.id.item1_youimage2);
        }
    }
    public class MyViewHolder2 extends RecyclerView.ViewHolder
    {
        private final ImageView item2_zuoimage;
        private final ImageView item2_zuoimage2;
        private final ImageView item2_youimage;
        private final TextView title2;

        public MyViewHolder2(View itemView) {
            super(itemView);
            title2 = itemView.findViewById(R.id.title2);
            item2_zuoimage = itemView.findViewById(R.id.item2_zuoimage);
            item2_zuoimage2 = itemView.findViewById(R.id.item2_zuoimage2);
            item2_youimage = itemView.findViewById(R.id.item2_youimage);
        }
    }
}
