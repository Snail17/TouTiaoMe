package com.xiaofeng.toutiao.http.retrofitclient;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2018/2/3.
 */

public final  class OkHttpUtils {
    private static final long TIMEOUT = 60 * 1000;
    private static OkHttpUtils sOkHttpUtils;
    private static OkHttpClient sOkHttpClient;


    public static OkHttpUtils getInstance() {
        if (sOkHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (sOkHttpUtils == null) {
                    sOkHttpUtils = new OkHttpUtils();
                }
            }
        }
        return sOkHttpUtils;
    }
    private OkHttpUtils() {
        sOkHttpClient = createOkHttpClient();
    }

    private OkHttpClient createOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor())
                .addInterceptor(new HeaderInterceptor())
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();


        return client;
    }

    public OkHttpClient getClient() {
        return sOkHttpClient;
    }

}
