package com.example.sixseconddemo.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.activity.UpdateAddressActivity;
import com.example.sixseconddemo.bean.showAddressBean;
import com.example.sixseconddemo.dao.AddDao;
import com.example.sixseconddemo.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 作者：author
 * 时间 ：2017/12/25:11:22
 * 说明：
 */

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.MyViewHolder>{
    Context context;
    List<showAddressBean> listaddress;
    AddDao addDao;
    int  flag=0;
    String isDefault="1";
    public AddressAdapter(Context context, List<showAddressBean> listaddress) {
        addDao=new AddDao(context);
        this.context = context;
        this.listaddress = listaddress;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.addressitems, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final showAddressBean bean = listaddress.get(position);
//        if(listaddress.get(position).getIschecked().equals("true")){
//            holder.itemcheckbox.isChecked();
//        }
        Log.i("---che----", "onBindViewHolder: "+bean.isIsDefault());
//        ContentValues values=new ContentValues();
//        values.put("addid",bean.getId()+"");
//        values.put("adduserid",bean.getUserId()+"");
//        values.put("consignee",bean.getConsignee());
//        values.put("phone",bean.getPhone());
//        values.put("addr",bean.getAddr());
//        values.put("zipCode",bean.getZipCode());
//        addDao.insertadd(values);
//        if(flag==0){
//            listaddress.get(0).setIsDefault(true);
//            setAddress();
//            holder.itemcheckbox.setChecked(bean.isIsDefault());
//        }
// else{
//            List<showAddressBean> queryadd = addDao.queryadd(isDefault);
//            holder.itemcheckbox.setChecked(queryadd.get(0).isIsDefault());
//        }
//        flag++;
        holder.tvname.setText(bean.getConsignee());
        holder.tvphone.setText(bean.getPhone());
        holder.tvmessage.setText(bean.getAddr());
        holder.itemcheckbox.setChecked(bean.isIsDefault());
        if(holder.itemcheckbox.isChecked()){
            holder.itemcheckbox.setText("已经默认");
            holder.itemcheckbox.setTextColor(Color.RED);
        }else{
            holder.itemcheckbox.setText("点击设置为默认");
            holder.itemcheckbox.setTextColor(Color.BLACK);
        }
        holder.itemcheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < listaddress.size(); i++) {
                    if (i!=position){
                        listaddress.get(i).setIsDefault(false);
                    }else{
                        listaddress.get(i).setIsDefault(true);
                    }
                }
                if(holder.itemcheckbox.isChecked()){
                    Map<String, String> mapup = new HashMap<>();
                    holder.itemcheckbox.setText("已经默认");
                    holder.itemcheckbox.setTextColor(Color.RED);
                    mapup.put("id", String.valueOf(listaddress.get(position).getId()));
                    mapup.put("is_default","true");
                    mapup.put("token","a918d4c8-4361-471f-b1a7-48648165274b");
                    mapup.put("consignee",listaddress.get(position).getConsignee());
                    mapup.put("phone",listaddress.get(position).getPhone());
                    mapup.put("zip_code",listaddress.get(position).getZipCode());
                    mapup.put("addr",listaddress.get(position).getAddr());
                    OkHttp3Utils.doPost("http://112.124.22.238:8081/course_api/addr/update", mapup, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Log.i("--++++++++success", "onResponse: "+"11111");
                        }
                    });
                }else if(holder.itemcheckbox.isChecked()==false){
                    Map<String, String> mapup2 = new HashMap<>();
                    holder.itemcheckbox.setText("点击设置为默认");
                    holder.itemcheckbox.setTextColor(Color.BLACK);
                    mapup2.put("id", String.valueOf(listaddress.get(position).getId()));
                    mapup2.put("is_default","false");
                    mapup2.put("token","a918d4c8-4361-471f-b1a7-48648165274b");
                    mapup2.put("consignee",listaddress.get(position).getConsignee());
                    mapup2.put("phone",listaddress.get(position).getPhone());
                    mapup2.put("zip_code",listaddress.get(position).getZipCode());
                    mapup2.put("addr",listaddress.get(position).getAddr());
                    OkHttp3Utils.doPost("http://112.124.22.238:8081/course_api/addr/update", mapup2, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Log.i("--++++++++success", "onResponse: "+"222222");
                        }
                    });
                }
//                setAddress();
                notifyDataSetChanged();
            }

        });

        holder.tvbj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zipCode = listaddress.get(position).getZipCode();
                String id = listaddress.get(position).getId()+"";
                String addr = listaddress.get(position).getAddr();
                String consignee = listaddress.get(position).getConsignee();
                String ischecked = listaddress.get(position).getIschecked();
                String phone = listaddress.get(position).getPhone();
                Intent intent = new Intent(context, UpdateAddressActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("addr",addr);
                intent.putExtra("consignee",consignee);
                intent.putExtra("ischecked",ischecked);
                intent.putExtra("phone",phone);
                intent.putExtra("zipCode",zipCode);
                context.startActivity(intent);

            }
        });
        holder.tvdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id = listaddress.get(position).getId()+"";
                String token="a918d4c8-4361-471f-b1a7-48648165274b";
                final Map<String, String> map = new HashMap<>();
                map.put("id",id);
                map.put("token",token);
                new AlertDialog.Builder(context)
                        .setTitle("确认删除吗?")
                        .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                OkHttp3Utils.doPost("http://112.124.22.238:8081/course_api/addr/del",map, new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                        Log.i("-------fail-------", "onFailure: "+"success");
                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        Log.i("-------del-------", "onFailure: "+"success");
                                        String string = response.body().string();
                                    }
                                });
                                listaddress.remove(position);
                                addDao.delete(id);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        })
                        .show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return listaddress==null?0:listaddress.size();
    }
    public void setAddress(){
        for (int i = 0; i < listaddress.size(); i++) {

            showAddressBean bean = listaddress.get(i);
            Log.i("------bean--------", "setAddress: "+bean.isIsDefault());
            if(bean.isIsDefault()){
                ContentValues values=new ContentValues();
                values.put("isDefault","1");
                addDao.update(values,bean.getId()+"");
            }else{
                ContentValues values=new ContentValues();
                values.put("isDefault","0");
                addDao.update(values,bean.getId()+"");
            }
        }
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvname)
        TextView tvname;
        @BindView(R.id.tvphone)
        TextView tvphone;
        @BindView(R.id.itemcheckbox)
        CheckBox itemcheckbox;
        @BindView(R.id.tvbj)
        TextView tvbj;
        @BindView(R.id.tvdel)
        TextView tvdel;
        @BindView(R.id.tvmessage)
        TextView tvmessage;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
