package com.example.sixseconddemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.FenLeiRight;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by 李倩 on 2017/12/21.
 */

public class Lv_RT_adapter extends XRecyclerView.Adapter<Lv_RT_adapter.ViewHolder>{
    Context mContext;
    FenLeiRight list;

    OnItemClickListener listener;
    public void  setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public Lv_RT_adapter(Context mContext, FenLeiRight list) {
        this.mContext=mContext;
        this.list=list;
    }

    @Override
    public Lv_RT_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(mContext, R.layout.right_item,null);
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
    public void onBindViewHolder(Lv_RT_adapter.ViewHolder holder, int position) {
        holder.tv_tname.setText(list.getList().get(position).getName());
        holder.tv_jprice.setText("￥"+list.getList().get(position).getPrice());
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(list.getList().get(position).getImgUrl()))
                .setAutoPlayAnimations(true)
                .build();
        holder.dsim.setController(controller);
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.getList().size();
    }

    public class ViewHolder extends XRecyclerView.ViewHolder {
        TextView tv_tname,tv_jprice;
        SimpleDraweeView dsim;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_tname= itemView.findViewById(R.id.tv_tname);
            tv_jprice= itemView.findViewById(R.id.tv_jprice);
            dsim=itemView.findViewById(R.id.Dsim);


        }
    }

    public  interface  OnItemClickListener{
        public  void onItemClick(int position);
    }

}
