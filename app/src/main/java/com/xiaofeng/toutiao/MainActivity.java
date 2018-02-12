package com.xiaofeng.toutiao;

import android.os.Bundle;

import com.xiaofeng.toutiao.base.BaseActivity;

import io.reactivex.Observable;
import io.reactivex.functions.Action;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
