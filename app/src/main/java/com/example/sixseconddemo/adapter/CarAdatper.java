package com.example.sixseconddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.CarBean;
import com.example.sixseconddemo.bean.EventCheck;
import com.example.sixseconddemo.bean.EventPriceAndNum;
import com.example.sixseconddemo.dao.CarDao;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 郭金龙 on 2017/12/20.
 */

public class CarAdatper extends RecyclerView.Adapter<CarAdatper.ViewHolder> {
    CarDao dao;
    List<CarBean> list;
    Context context;
    OnClick listener;
    public void setOnClick(OnClick listener){
        this.listener=listener;
    }
    public CarAdatper(Context context) {
        dao = new CarDao(context);
        this.context = context;
    }

    public void getData() {
        List<CarBean> carBeans = dao.queryAll();
        this.list = carBeans;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.fragfouth_car_item,null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClickListenre((Integer) v.getTag());
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setTag(position);
        final CarBean bean = list.get(position);
        holder.carTitle.setText(bean.getTitle());
        DraweeController build = Fresco.newDraweeControllerBuilder().setUri(bean.getImg()).build();
        holder.carSd.setController(build);
        holder.carPrice.setText(bean.getPrice());
        holder.carCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean.setChecked(holder.carCb.isChecked());
                EventPriceAndNum compute = compute();
                EventBus.getDefault().post(compute);
                if(ischeckitemAll(position)){
                    CheckALLstate(true);
                }else{
                    CheckALLstate(false);
                }
                notifyDataSetChanged();
            }
        });
        holder.carAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num=0;
                num = bean.getNum();
                holder.carNum.setText(++num+"");
                bean.setNum(num);
                if(bean.isChecked()){
                    EventPriceAndNum compute = compute();
                    EventBus.getDefault().post(compute);
                }
            }
        });
        holder.carDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num=0;
                num = bean.getNum();
                if(num==1){
                    Toast.makeText(context, "你是要取消该商品吗？请点击编辑取消", Toast.LENGTH_SHORT).show();
                    return;
                }
                holder.carNum.setText(--num+"");
                bean.setNum(num);
                if(bean.isChecked()){
                    EventPriceAndNum compute = compute();
                    EventBus.getDefault().post(compute);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.car_cb)
        CheckBox carCb;
        @BindView(R.id.car_sd)
        SimpleDraweeView carSd;
        @BindView(R.id.car_title)
        TextView carTitle;
        @BindView(R.id.car_price)
        TextView carPrice;
        @BindView(R.id.car_del)
        ImageView carDel;
        @BindView(R.id.car_num)
        TextView carNum;
        @BindView(R.id.car_add)
        ImageView carAdd;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    //回调jiek
    public interface OnClick{
        void OnClickListenre(int position);
    }
    //删除的方法
    public void delete(int posrtion){
        list.remove(posrtion);
        dao.delete(list.get(posrtion).getTitle());
        EventBus.getDefault().post(compute());
        notifyDataSetChanged();
    }
    //判断全选和反选
    public void changAllListCbState(boolean flag){
        for (int i = 0; i < list.size(); i++) {
            CarBean bean = list.get(i);
            bean.setChecked(flag);
        }
        EventPriceAndNum compute = compute();
        EventBus.getDefault().post(compute);
        notifyDataSetChanged();
    }
    //发送当前状态
    public void CheckALLstate(boolean flag){
        EventCheck check=new EventCheck();
        check.setChecked(flag);
        EventBus.getDefault().post(check);
    }
    //判断所有条目是否全部选中
    public boolean ischeckitemAll(int position){
        CarBean bean = list.get(position);
        if(!bean.isChecked()){
            return false;
        }
        return true;
    }
    //计算选中的条目
    public EventPriceAndNum compute(){
       int price=0;
       int num=0;
        for (int i = 0; i < list.size(); i++) {
            CarBean bean = list.get(i);
            if(bean.isChecked()){
                num+=bean.getNum();
                price+=bean.getNum()*Integer.parseInt(bean.getPrice());
            }
        }
        EventPriceAndNum priceAndNum=new EventPriceAndNum();
        priceAndNum.setNum(num);
        priceAndNum.setPrice(price);
        return priceAndNum;
    }
}
