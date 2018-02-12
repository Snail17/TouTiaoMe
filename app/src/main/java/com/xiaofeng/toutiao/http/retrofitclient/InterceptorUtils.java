package com.xiaofeng.toutiao.http.retrofitclient;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/2/8.
 */

public class InterceptorUtils {
    private static InterceptorUtils mUtils;

    public static InterceptorUtils getInstance() {
        if (mUtils == null) {
            synchronized (InterceptorUtils.class) {
                if (mUtils == null) {
                    mUtils = new InterceptorUtils();
                }
            }
        }
        return mUtils;
    }
    private InterceptorUtils() {
    }

    public Request addHeader(Request request) {
        Request.Builder builder = request.newBuilder().addHeader("Acc_lauguage", "CN");
        return builder.build();
    }
}
