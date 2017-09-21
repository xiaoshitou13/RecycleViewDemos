package com.example.bawi.recycleviewdemos;

import android.app.Application;

import org.xutils.x;

/**
 * Created by 白玉春 on 2017/9/21.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initxUtils();

    }

    private void initxUtils() {
    		x.Ext.init(this);//必须的
    		x.Ext.setDebug(BuildConfig.DEBUG); // 可选的，是否输出debug日志, 开启debug会影响性能.
    	}

}
