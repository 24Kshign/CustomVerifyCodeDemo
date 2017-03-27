package com.share.jack.customverifycodeviewdemo.model.api;


import com.share.jack.customverifycodeviewdemo.http.BaseRetrofit;

/**
 *
 */
public class BaseModel extends BaseRetrofit {

    protected MainApi mServletApi;

    public BaseModel() {
        super();
        mServletApi = mRetrofit.create(MainApi.class);
    }

    public void onUnSubscribe() {
        //取消注册，以避免内存泄露
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions())
            mCompositeSubscription.unsubscribe();
    }
}
