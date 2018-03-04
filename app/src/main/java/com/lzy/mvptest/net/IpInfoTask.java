package com.lzy.mvptest.net;

import android.widget.Toast;

import com.lzy.mvptest.callback.LoadTaskCallBack;
import com.lzy.mvptest.model.IpInfo;

import java.io.IOException;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.RequestParams;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Adminstrator on 2018/3/3.
 */

public class IpInfoTask implements NetTask<String> {
//    private static final String HOST = "http://ip.taobao.com/service/getIpInfo.php";
    private static final String HOST = "http://ip.chinaz.com/getip.aspx";

    private IpInfoTask() {
    }

    /*
    * 静态内部类单例模式
    * */
    private static class IpInfoHolder {

        public static final IpInfoTask IP_INFO_TASK = new IpInfoTask();
    }

    public static IpInfoTask getInstance() {
        return IpInfoHolder.IP_INFO_TASK;
    }

    //DCL单例模式
//      private static IpInfoTask INSTANCE = null;
//    public static IpInfoTask getInstance() {
//        if (INSTANCE == null) {
//            synchronized (IpInfoTask.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new IpInfoTask();
//                }
//            }
//        }
//        return INSTANCE;
//    }

    @Override
    public void execute(String ip, final LoadTaskCallBack callback) {
        RequestParams params = new RequestParams();
        params.addFormDataPart("ip", ip);
//
//        OkHttpClient okHttpClient=new OkHttpClient.Builder().build();
//        Request request=new Request.Builder().url(HOST).build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//String str=response.body().string();
//            }
//        });

        HttpRequest.post(HOST, params, new BaseHttpRequestCallback<IpInfo>() {
            @Override
            public void onStart() {
                super.onStart();
                callback.onStart();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                callback.onFinish();
            }

            @Override
            protected void onSuccess(IpInfo ipInfo) {
                super.onSuccess(ipInfo);
                callback.onSuccess(ipInfo);
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                callback.onFailed();
            }
        });
    }
}
