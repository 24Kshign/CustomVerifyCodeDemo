package com.share.jack.customverifycodeviewdemo.model;


import com.share.jack.customverifycodeviewdemo.http.HttpResultFunc;
import com.share.jack.customverifycodeviewdemo.model.api.BaseModel;
import com.share.jack.customverifycodeviewdemo.model.entity.RecyclerViewBean;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 *
 */

public class RecyclerViewModel extends BaseModel {

    private static class SingletonInstance {
        private static RecyclerViewModel Instance = new RecyclerViewModel();
    }

    public static RecyclerViewModel getInstance() {
        return SingletonInstance.Instance;
    }

    public void executePost(Subscriber<List<RecyclerViewBean>> subscriber) {
        Observable observable = mServletApi.getMainInfoByPost().map(new HttpResultFunc());
        toSubscribe(observable, subscriber);
    }

    public void executeGet(Subscriber<List<RecyclerViewBean>> subscriber) {
        Observable observable = mServletApi.getMainInfoByGet().map(new HttpResultFunc());
        toSubscribe(observable, subscriber);
    }
}