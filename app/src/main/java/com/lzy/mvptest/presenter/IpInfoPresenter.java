package com.lzy.mvptest.presenter;

import com.lzy.mvptest.IpInfoContract;
import com.lzy.mvptest.callback.LoadTaskCallBack;
import com.lzy.mvptest.model.IpInfo;
import com.lzy.mvptest.net.NetTask;

/**
 * Created by Adminstrator on 2018/3/4.
 */

public class IpInfoPresenter implements IpInfoContract.Presenter, LoadTaskCallBack<IpInfo> {
    NetTask netTask;
    IpInfoContract.View view;

    public IpInfoPresenter(NetTask netTask, IpInfoContract.View view) {
        this.netTask = netTask;
        this.view = view;
    }

    @Override
    public void getIpInfo(String ip) {
        netTask.execute(ip, this);
    }

    @Override
    public void onSuccess(IpInfo ipInfo) {
        if (view.isActive()) {
            view.setIpInfo(ipInfo);
        }
    }

    @Override
    public void onStart() {
        if (view.isActive()) {
            view.showLoading();
        }
    }

    @Override
    public void onFailed() {
        if (view.isActive()) {
            view.showError();
            view.hideLoading();
        }
    }

    @Override
    public void onFinish() {
        if (view.isActive()) {
            view.hideLoading();
        }
    }
}
