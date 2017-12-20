package com.example.sixseconddemo.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sixseconddemo.R;
import com.example.sixseconddemo.activity.LoginActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 郭金龙 on 2017/12/19.
 */

public class FragmentFifth extends Fragment {
    @BindView(R.id.sdvtou)
    SimpleDraweeView sdvtou;
    @BindView(R.id.tvtou)
    TextView tvtou;
    @BindView(R.id.rvmine)
    RecyclerView rvmine;
    Unbinder unbinder;
    private View view;
    String url="res://com.example.sixseconddemo/"+R.drawable.default_head;
    List<String> listtvs=new ArrayList<>();
    List<Integer> listimages=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragfifth, null);
        unbinder = ButterKnife.bind(this, view);
        createTouFresco();
        initRvfifth();
        return view;

    }

    private void initRvfifth() {
        listtvs.add("我的订单");
        listtvs.add("我的收藏");
        listtvs.add("收货地址");
        listimages.add(R.drawable.icon_list_o);
        listimages.add(R.drawable.icon_favorite);
        listimages.add(R.drawable.icon_location);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvmine.setLayoutManager(llm);
        MyFIFTHAdapter myFIFTHAdapter = new MyFIFTHAdapter();
        rvmine.setAdapter(myFIFTHAdapter);
    }

    private void createTouFresco() {
        Uri uri = Uri.parse(url);
        sdvtou.setImageURI(uri);
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request).setAutoPlayAnimations(true).build();
        sdvtou.setController(controller);
        sdvtou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

            }
        });
    }
    class MyFIFTHAdapter extends RecyclerView.Adapter<MyFIFTHAdapter.MyViewHolder>{


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View conview=View.inflate(getActivity(),R.layout.fifthrvitems,null);
            MyViewHolder myViewHolder = new MyViewHolder(conview);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.iv.setImageResource(listimages.get(position));
            holder.tv.setText(listtvs.get(position));
        }

        @Override
        public int getItemCount() {
            return listimages.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView iv;
            TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
                iv=itemView.findViewById(R.id.ivrvfifth);
                tv=itemView.findViewById(R.id.tvfifth);
            }
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
