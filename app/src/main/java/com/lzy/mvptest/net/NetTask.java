package com.lzy.mvptest.net;

import com.lzy.mvptest.callback.LoadTaskCallBack;

/**
 * Created by Adminstrator on 2018/3/3.
 */

public interface NetTask<T> {
    void execute(T data,LoadTaskCallBack callback);
}
