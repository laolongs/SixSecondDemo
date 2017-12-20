package com.example.sixseconddemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.FenleiLeft;

import java.util.List;

/**
 * Created by 李倩 on 2017/12/20.
 */

public class LeftAdapter extends BaseAdapter {
    Context context;
    List<FenleiLeft> flist;

    public LeftAdapter(Context context,List<FenleiLeft> flist) {
        this.context = context;
        this.flist = flist;
    }
    @Override
    public int getCount() {
        return flist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            convertView=convertView.inflate(context, R.layout.lv_left,null);
            holder=new ViewHolder();
            holder.lv_tv=convertView.findViewById(R.id.lv_tv);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        holder.lv_tv.setText(flist.get(position).getName());
        return convertView;
    }
    class ViewHolder{
        TextView lv_tv;
    }
}
