package com.xiaofeng.toutiao.base;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.xiaofeng.toutiao.utils.LoadingUtils;

/**
 * Created by Administrator on 2018/1/28.
 */

public class BaseActivity extends RxAppCompatActivity implements ILoading{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppManager.getInstance().addActivity(this);
    }


    @Override
    public void showLoading() {
        LoadingUtils.showLoading(this);
    }

    @Override
    public void hideLoading() {
        LoadingUtils.hideDialog();
    }

    @Override
    public void showLoadingWithClose() {
        LoadingUtils.showLoadingWithClose(this);
    }
}
