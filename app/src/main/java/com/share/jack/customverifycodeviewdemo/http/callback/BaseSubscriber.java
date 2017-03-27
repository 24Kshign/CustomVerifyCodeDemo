package com.share.jack.customverifycodeviewdemo.http.callback;

import android.app.Activity;
import android.util.Log;

import com.share.jack.customverifycodeviewdemo.http.progress.ProgressDialogHandler;

import rx.Subscriber;

/**
 * BaseSubscriber
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {

    private static final String TAG="BaseSubscriber";

    protected abstract void onBaseError(Throwable t);

    protected abstract void onBaseNext(T data);

    protected abstract boolean isNeedProgressDialog();

    protected abstract String getTitleMsg();

    private ProgressDialogHandler mProgressDialogHandler;

    public BaseSubscriber(Activity activity) {
        mProgressDialogHandler = new ProgressDialogHandler(activity, true);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG, getTitleMsg()).sendToTarget();
        }
    }

    protected void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }


    @Override
    public void onError(Throwable t) {
        //关闭进度条
        if (isNeedProgressDialog()) {
            dismissProgressDialog();
        }
        onBaseError(t);
    }

    //订阅开始
    @Override
    public void onStart() {
        Log.i(TAG, "请求开始");
        //显示进度条
        if (isNeedProgressDialog()) {
            showProgressDialog();
        }
    }

    //订阅完成
    @Override
    public void onCompleted() {
        Log.i(TAG, "请求完成");
        //关闭进度条
        if (isNeedProgressDialog()) {
            dismissProgressDialog();
        }
    }

    @Override
    public void onNext(T t) {
        onBaseNext(t);
    }
}
