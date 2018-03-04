package com.lzy.mvptest.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.mvptest.IpInfoContract;
import com.lzy.mvptest.R;
import com.lzy.mvptest.model.IpInfo;

/**
 * Created by Adminstrator on 2018/3/4.
 */

public class IpInfoFragment extends Fragment implements IpInfoContract.View {
    IpInfoContract.Presenter mPresenter;
    //    IpInfo mIpInfo;
    private ProgressDialog dialog;
//    private TextView tv_country;
//    private TextView tv_city;
    private TextView tv_area;
    private TextView tv_ip;
    private Button btn_commit;

    @Override
    public void setPresenter(IpInfoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setIpInfo(IpInfo ipInfo) {
//        mIpInfo = ipInfo;
        if (ipInfo != null ) {
//            tv_country.setText(ipInfo.getData().getCountry());
//            tv_city.setText(ipInfo.getData().getCity());
            tv_area.setText(ipInfo.getAddress());
            tv_ip.setText(ipInfo.getIp());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.ipinfo_fragment, null);
//        tv_country = view.findViewById(R.id.tv_country);
//        tv_city = view.findViewById(R.id.tv_city);
        tv_area = view.findViewById(R.id.tv_area);
        tv_ip=view.findViewById(R.id.tv_ip);
        btn_commit = view.findViewById(R.id.btn_commit);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dialog = new ProgressDialog(getActivity());
        dialog.setTitle("正在获取数据");
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getIpInfo("39.155.184.147");
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dialog.dismiss();
    }

    @Override
    public void showLoading() {
        if(!dialog.isShowing()){

            dialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(),"网络错误",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
