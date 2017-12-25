package com.example.sixseconddemo.adapter;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.api.GetRequest_In;
import com.example.sixseconddemo.base.Base;
import com.example.sixseconddemo.bean.BestSellerBean;
import com.example.sixseconddemo.bean.EventPass;
import com.example.sixseconddemo.bean.ShouyeBean;
import com.example.sixseconddemo.bean.SoucangBean;
import com.example.sixseconddemo.dao.CarDao;
import com.example.sixseconddemo.utils.OkHttp3Utils;
import com.example.sixseconddemo.utils.RetrofitManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by oneDream on 2017/12/21.
 */

public class SCshow_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<SoucangBean> slist;
    OnItemClickListener listener;
    private View view;

    public void  setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SCshow_adapter(Context context, List<SoucangBean> slist) {
        this.context = context;
        this.slist = slist;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.second_item,null);

        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder myViewHolder = (ViewHolder)holder;
        myViewHolder.tv_title.setText(slist.get(position).getWares().getName());
        myViewHolder.tv_price.setText("￥"+slist.get(position).getWares().getPrice());
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(slist.get(position).getWares().getImgUrl()))
                .build();
        myViewHolder.sim.setController(controller);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("确定要删除么?");
                builder.setNegativeButton("取消",null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("id",slist.get(position).getId()+"");
                        hashMap.put("token","a918d4c8-4361-471f-b1a7-48648165274b");
                        OkHttp3Utils.doPost("http://112.124.22.238:8081/course_api/favorite/del", hashMap, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {

                            }
                        });

                        slist.remove(slist.get(position));
                        notifyDataSetChanged();
                    }
                });
                builder.create().show();
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
