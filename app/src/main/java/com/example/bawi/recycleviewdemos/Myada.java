package com.example.bawi.recycleviewdemos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 白玉春 on 2017/9/21.
 */

public class Myada extends RecyclerView.Adapter<Myada.ViewHolder>{

    public List<Myadater.DataBean.ReturnDataBean.ComicsBean> datas  ;
    public Context context;


    public Myada(List<Myadater.DataBean.ReturnDataBean.ComicsBean> datas,Context context) {
        this.datas = datas;
        this.context = context;
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //获取item布局
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //给item里面的东西设置值
        viewHolder.name.setText(datas.get(position).getName());
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //获取item里面的id
        public TextView name;
        public ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.text);

        }
    }
}
