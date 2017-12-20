package com.example.sixseconddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.ShouyeBean;

import java.util.List;

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
            MyViewHolder myViewHolder = (MyViewHolder)holder;

        } else {
            MyViewHolder2 myViewHolder = (MyViewHolder2)holder;

        }
    }

    @Override
    public int getItemCount() {
        return shouyeBean.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
    public class MyViewHolder2 extends RecyclerView.ViewHolder
    {
        public MyViewHolder2(View itemView) {
            super(itemView);
        }
    }
}
