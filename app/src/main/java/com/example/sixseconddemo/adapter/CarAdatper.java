package com.example.sixseconddemo.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.activity.OrderActivity;
import com.example.sixseconddemo.activity.XQActivity;
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

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setTag(position);
        final CarBean bean = list.get(position);
        holder.carCb.setChecked(bean.isChecked());
        holder.carTitle.setText(bean.getTitle());
        DraweeController build = Fresco.newDraweeControllerBuilder().setUri(bean.getImg()).build();
        holder.carSd.setController(build);
        holder.carPrice.setText("￥"+bean.getPrice());
        holder.carCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean.setChecked(holder.carCb.isChecked());
                EventPriceAndNum compute = compute();
                EventBus.getDefault().post(compute);
                if(ischeckitemAll()){
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, XQActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i("-----list-------", "getItemCount: "+list.size());
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
    public void delete(){
        for (int i = 0; i < list.size(); i++) {

                CarBean bean = list.get(i);
                    if(bean.isChecked())
                    {
                        list.remove(i);
                        i--;
                        dao.delete(bean.getTitle());
                    }
                    Log.i("----list.size--", "delete: "+list.size()+"----"+dao.queryAll().size());
                    EventBus.getDefault().post(compute());
                    notifyDataSetChanged();


        }

    }
    //判断全选和反选
    public void changAllListCbState(boolean flag){
        for (int i = 0; i < list.size(); i++) {
            CarBean bean = list.get(i);
            bean.setChecked(flag);
            Log.i("----全选-------", "changAllListCbState: "+flag);
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
    public boolean ischeckitemAll( ){
        for (int i = 0; i < list.size(); i++) {
            CarBean bean = list.get(i);
            if(!bean.isChecked()){
                return false;
            }
        }
        return true;
    }
    //计算选中的条目
    public EventPriceAndNum compute(){
       int price=0;
       int num=1;
        for (int i = 0; i < list.size(); i++) {
            CarBean bean = list.get(i);
            if(bean.isChecked()){
                num+=bean.getNum();
                price+=bean.getNum()*Double.parseDouble(bean.getPrice());
            }
        }
        EventPriceAndNum priceAndNum=new EventPriceAndNum();
        Log.i("-----price------", "compute: "+price);
        priceAndNum.setNum(num);
        priceAndNum.setPrice(price);
        return priceAndNum;
    }
    public void select(){
            int a=0;
            for (int i = 0; i < list.size(); i++) {
                CarBean bean = list.get(i);
                if(bean.isChecked()){
                    a++;
                    ContentValues values=new ContentValues();
                    values.put("flag","1");
                    dao.update(values,bean.getUserid());
                }else{
                    ContentValues values=new ContentValues();
                    values.put("flag","0");
                    dao.update(values,bean.getUserid());
                }
        }
        if(a>0){
            Intent intent=new Intent(context, OrderActivity.class);
            context.startActivity(intent);
        }else{
            Toast.makeText(context, "请选择商品", Toast.LENGTH_SHORT).show();
            return;
        }


    }
}
