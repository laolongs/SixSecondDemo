package com.example.sixseconddemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.bean.LaoLiShiBean;
import com.example.sixseconddemo.bean.ShouyeguanggaoBean;
import com.example.sixseconddemo.bean.WanNengBean;
import com.example.sixseconddemo.utils.OkHttp3Utils;
import com.example.sixseconddemo.utils.Sou_utils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SousuoXiangqingActivity extends AppCompatActivity {
    ImageView    ss_fh2;
    TextView ss_name2;
    RecyclerView rrvv;
    String path,pathlls;
    WanNengBean sssbean;
    LaoLiShiBean llsbean;
    ShouyeguanggaoBean shouyebean;
    MyRVadapter   rvadapter;
    MyRV22adapter   rv22adapter;
    private List<LaoLiShiBean.DatasBean.GoodsListBean> goods_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo22);
        Fresco.initialize(this);
        ss_fh2= (ImageView) findViewById(R.id.sss_fh2);

        rrvv= (RecyclerView) findViewById(R.id.rrvv);
        String inn=getIntent().getStringExtra("name");

        ss_name2= (TextView) findViewById(R.id.ss_name2);
        ss_name2.setText(inn);

        initclick();
        initData();

        String s = Sou_utils.jiami(Sou_utils.convertStringToUTF8(inn));
        if(inn.equals("劳力士"))
        {
            pathlls="http://169.254.239.49/mobile/index.php?act=goods&op=goods_list&page=100";
            getllshttp();
            rv22adapter=new MyRV22adapter();
            rv22adapter.setOnItemClickLinstener(new OnItemClickLinstener() {
                @Override
                public void OnItemClick(View view, int position) {

                }
            });
        }else {
            path="http://list.mogujie.com/search?_version=61&ratio=3%3A4&q="+s+"%22&cKey=46&minPrice=&_mgjuuid=dbcc6b5c-fcf7-49f4-b807-3e85fbcccc5b&ppath=&page=1&maxPrice=&sort=pop&userId=&cpc_offset=&priceList=&_=1504520539364&callback=jsonp1";
            getokhttp();
        }
    }
    private void initData() {
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rrvv.setLayoutManager(manager);
        rrvv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
    private void initclick() {
        ss_fh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    //万能的网络获取
    public void getokhttp() {
        OkHttp3Utils.doGet(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful())
                {
                    String  www=response.body().string();

                    final String re=www.substring(11, www.length() - 2);
                    Log.i("shop==============",re);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson=new Gson();
                            sssbean=gson.fromJson(re,WanNengBean.class);
                            rvadapter=new MyRVadapter(sssbean);
                            rrvv.setAdapter(rvadapter);
                        }
                    });
                }
            }
        });
    }
    //劳力士的网络获取
    public void getllshttp() {
        OkHttp3Utils.doGet(pathlls, new Callback() {
            @Override
            public void onFailure(Call call2, IOException e2) {

            }

            @Override
            public void onResponse(Call call2, Response response2) throws IOException {

                if(response2.isSuccessful())
                {
                    Gson gson=new Gson();
                    String sss=response2.body().string();
                    llsbean=gson.fromJson(sss,LaoLiShiBean.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            rrvv.setAdapter(rv22adapter);
                        }
                    });


                }

            }
        });
    }
//万能的适配器
class MyRVadapter extends RecyclerView.Adapter<MyRVadapter.MyViewHodler>{
    WanNengBean es;

    public MyRVadapter(WanNengBean es) {
        this.es = es;
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View   view=View.inflate(SousuoXiangqingActivity.this,R.layout.ss_rv_item2,null);
        MyViewHodler    holder=new MyViewHodler(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {

        holder.tv.setText("名称："+es.getResult().getWall().getDocs().get(position).getTitle());

        DraweeController dc= Fresco.newDraweeControllerBuilder()
                .setUri(es.getResult().getWall().getDocs().get(position).getImg())
                .setAutoPlayAnimations(true)
                .build();
        holder.img.setController(dc);
    }

    @Override
    public int getItemCount() {
        return es.getResult().getWall().getDocs().size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder{
        SimpleDraweeView img;
        TextView   tv;

        public MyViewHodler(View itemView) {
            super(itemView);
            img= (SimpleDraweeView) itemView.findViewById(R.id.ss_rv_img22);
            tv= (TextView) itemView.findViewById(R.id.ss_rv_tv22);
        }
    }
}

//劳力士的适配器
class MyRV22adapter extends RecyclerView.Adapter<MyRV22adapter.My22ViewHodler>{

    OnItemClickLinstener   listener;
    //获取方法的传参值
    public void setOnItemClickLinstener(OnItemClickLinstener listener) {
        //指定当前的值
        this.listener = listener;
    }


    @Override
    public My22ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view2=View.inflate(SousuoXiangqingActivity.this,R.layout.ss_rv_item2,null);
        My22ViewHodler   holder2=new My22ViewHodler(view2);

        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                //实例化listener来调用接口的方法    强转类型
                listener.OnItemClick(view2, (int) view2.getTag());
            }
        });
        return holder2;
    }

    @Override
    public void onBindViewHolder(My22ViewHodler holder, int position) {


        holder.tv2.setText("名称："+llsbean.getDatas().getGoods_list().get(position).getGoods_name());

        DraweeController dc= Fresco.newDraweeControllerBuilder()
                .setUri(llsbean.getDatas().getGoods_list().get(position).getGoods_image_url())
                .setAutoPlayAnimations(true)
                .build();
        holder.img2.setController(dc);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return llsbean.getDatas().getGoods_list().size();
    }

    class My22ViewHodler extends RecyclerView.ViewHolder{
        SimpleDraweeView img2;
        TextView   tv2;

        public My22ViewHodler(View itemView) {
            super(itemView);
            img2= (SimpleDraweeView) itemView.findViewById(R.id.ss_rv_img22);
            tv2= (TextView) itemView.findViewById(R.id.ss_rv_tv22);
        }
    }
}

    //创建接口
    public  interface OnItemClickLinstener{
        //创建接口的方法
        public void OnItemClick(View view, int position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
