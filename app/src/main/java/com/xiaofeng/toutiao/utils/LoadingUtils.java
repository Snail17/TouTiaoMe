package com.xiaofeng.toutiao.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xiaofeng.toutiao.R;

/**
 * Created by Administrator on 2018/1/28.
 */

public class LoadingUtils {

    private static ImageView imClose;
    private static Dialog loadingDialog;

    public static Dialog showLoading(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_loding_layout, null);

        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.pb_loading_progress_bar);
        TextView loadingText = (TextView) view.findViewById(R.id.tv_loading_text);

        if (loadingDialog == null) {
            loadingDialog = new Dialog(context);
        }

        loadingDialog.setContentView(view);
        // dialog弹出后会点击屏幕或物理返回键，dialog不消失
        loadingDialog.setCancelable(false);
        // dialog弹出后会点击屏幕，dialog消失；
        loadingDialog.setCanceledOnTouchOutside(true);

        Window window = loadingDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        loadingDialog.show();

        return loadingDialog;
    }


    public static void hideDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }


}
