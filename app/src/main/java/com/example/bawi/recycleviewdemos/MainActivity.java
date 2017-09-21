package com.example.bawi.recycleviewdemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.x;

public class MainActivity extends AppCompatActivity implements XRecyclerView.LoadingListener{

    private XRecyclerView xRecyclerView;
    int page = 1;
    private Myadater madater;
    private List<Myadater.DataBean.ReturnDataBean.ComicsBean> list;
    private String urlPath ="http://app.u17.com/v3/appV3_3/android/phone/list/commonComicList?argValue=23&argName=sort&argCon=0&android_id=4058040115108878&v=3330110&model=GT-P5210&come_from=Tg002&page=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xRecyclerView = (XRecyclerView) findViewById(R.id.xrecy);

        xutils(page);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setLoadingListener(this);

    }

    private void xutils( int page) {
        RequestParams entity = new RequestParams(urlPath+page);

      org.xutils.x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Myadater been = new Gson().fromJson(result, Myadater.class);
                list = new ArrayList<Myadater.DataBean.ReturnDataBean.ComicsBean>();
                list.addAll(been.getData().getReturnData().getComics());
                Myada  m = new Myada(list,MainActivity.this);
                xRecyclerView.setAdapter(m);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                //刷新完成
                xRecyclerView.refreshComplete();
                xRecyclerView.loadMoreComplete();
            }
        });

    }

    @Override
    public void onRefresh() {//刷新
        page = 1;
        xutils(page);
    }

    @Override
    public void onLoadMore() {// 加载更多
        page++;
        xutils(page);
    }

}
