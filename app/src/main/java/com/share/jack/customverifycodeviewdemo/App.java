package com.share.jack.customverifycodeviewdemo;

import android.app.Application;

import com.share.jack.customverifycodeviewdemo.http.HttpServletAddress;

/**
 * Created by jack on 17/3/27
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpServletAddress.getInstance().setOnlineAddress("http://www.imooc.com/");
    }
}
