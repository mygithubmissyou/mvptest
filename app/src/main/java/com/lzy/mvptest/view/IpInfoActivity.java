package com.lzy.mvptest.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lzy.mvptest.R;
import com.lzy.mvptest.net.IpInfoTask;
import com.lzy.mvptest.presenter.IpInfoPresenter;

public class IpInfoActivity extends AppCompatActivity {
    IpInfoPresenter ipInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_info);
        IpInfoFragment ipInfoFragment = (IpInfoFragment) getSupportFragmentManager().findFragmentById(R.id.fl_contentframe);
        if (ipInfoFragment == null) {
            ipInfoFragment = new IpInfoFragment();
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fl_contentframe,ipInfoFragment);
            transaction.commit();
        }
        ipInfoPresenter=new IpInfoPresenter(IpInfoTask.getInstance(),ipInfoFragment);
        ipInfoFragment.setPresenter(ipInfoPresenter);
    }
}
