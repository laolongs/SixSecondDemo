package com.example.sixseconddemo.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.showAddressBean;
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

    public AddressAdapter(Context context, List<showAddressBean> listaddress) {
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
        holder.tvname.setText(listaddress.get(position).getConsignee());
        holder.tvphone.setText(listaddress.get(position).getPhone());
        holder.tvmessage.setText(listaddress.get(position).getAddr());
        holder.itemcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                   holder.itemcheckbox.setText("已设置为默认");
                   holder.itemcheckbox.setTextColor(Color.RED);
                   listaddress.get(position).setIsDefault(true);
                }else{
                    holder.itemcheckbox.setText("设为默认");
                    holder.itemcheckbox.setTextColor(Color.BLACK);
                    listaddress.get(position).setIsDefault(false);
                }
            }
        });
        holder.tvdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = listaddress.get(position).getId()+"";
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
