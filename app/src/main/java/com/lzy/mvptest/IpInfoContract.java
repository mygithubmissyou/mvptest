package com.lzy.mvptest;

import com.lzy.mvptest.model.IpInfo;
import com.lzy.mvptest.view.BaseView;

/**
 * Created by Adminstrator on 2018/3/3.
 */

public interface IpInfoContract {
    interface Presenter{
        void getIpInfo(String ip);
    }
    interface View extends BaseView<Presenter>{
        void setIpInfo(IpInfo ipInfo);
        void showLoading();
        void hideLoading();
        void showError();
        boolean isActive();
    }
}
