package com.xiaofeng.toutiao.http.retrofitclient;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/2/7.
 */

public class NetworkInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        logRequest();
        Response response = chain.proceed(request);
        logResponse();
        return response;
    }

    private void logResponse() {

    }

    private void logRequest() {

    }
}
