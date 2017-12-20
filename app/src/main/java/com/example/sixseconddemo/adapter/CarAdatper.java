package com.example.sixseconddemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

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

public class CarAdatper extends BaseAdapter {
    CarDao dao;
    List<CarBean> list;
    Context context;

    public CarAdatper(Context context) {
        dao = new CarDao(context);
        this.context = context;
    }

    public void getData() {
        List<CarBean> carBeans = dao.queryAll();
        this.list = carBeans;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder hodler;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.fragfouth_car_item, null);
            hodler = new ViewHolder(convertView);
            convertView.setTag(hodler);
        }else{
            hodler = (ViewHolder) convertView.getTag();
        }
        final CarBean bean = list.get(position);
        hodler.carTitle.setText(bean.getTitle());
        DraweeController build = Fresco.newDraweeControllerBuilder().setUri(bean.getImg()).build();
        hodler.carSd.setController(build);
        hodler.carPrice.setText(bean.getPrice());
        hodler.carCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean.setChecked(hodler.carCb.isChecked());
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
        return convertView;
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

    static class ViewHolder {
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

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
