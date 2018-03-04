package com.lzy.mvptest.callback;

/**
 * Created by Adminstrator on 2018/3/3.
 */

public interface LoadTaskCallBack<T> {
    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();
}
