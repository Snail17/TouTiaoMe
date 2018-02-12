package com.xiaofeng.toutiao.http.retrofitclient;

import com.xiaofeng.toutiao.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/2/6.
 */

public final class RetrofitFactory {

    private static RetrofitFactory sRetrofitFactory;
    private static Retrofit.Builder sRetrofitBuilder;
    private static OkHttpClient sClient;

    public static RetrofitFactory getsRetrofitFactory() {
        if (sRetrofitFactory == null) {
            synchronized (RetrofitFactory.class) {
                if (sRetrofitFactory == null) {
                    sRetrofitFactory = new RetrofitFactory();
                }
            }
        }
        return sRetrofitFactory;
    }

    private  RetrofitFactory() {
        sClient = OkHttpUtils.getInstance().getClient();
        sRetrofitBuilder = getRetrofitBuilder();
    }

    private  Retrofit.Builder getRetrofitBuilder() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder;
    }

    public Retrofit getRetrofit() {
        return sRetrofitBuilder.client(sClient).build();
    }

    public static <S> S createService(Class<S> serviceClass) {
        return getsRetrofitFactory().getRetrofit().create(serviceClass);
    }
}
