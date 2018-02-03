package com.xiaofeng.toutiao.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * Created by Administrator on 2018/1/28.
 */

public class AppManager {

    private volatile static AppManager managerInstance;
    private Stack<Activity> mActivities;

    private AppManager(){}

    public static AppManager getInstance() {
        if (managerInstance == null) {
            synchronized (AppManager.class) {
                if (managerInstance == null) {
                    managerInstance = new AppManager();
                }
            }
        }
        return managerInstance;
    }

    /**
     * 删除 Activity
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (mActivities != null) {
            mActivities.remove(activity);
            activity.finish();
        }
    }

    /**
     * 添加Activity
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (mActivities == null) {
            mActivities = new Stack<>();
        }
        mActivities.add(activity);
    }

    public void finishAll() {
        if (mActivities != null) {
            for (int i = 0, len = mActivities.size(); i < len; i++) {
                if (mActivities.get(i) != null) {
                    mActivities.get(i).finish();
                }
            }
        }
        mActivities.clear();
    }

    /**
     *
     * @param context
     * @param isBackground
     */
    public void appExit(Context context, Boolean isBackground) {
       try {
           finishAll();
           ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
           am.restartPackage(context.getPackageName());
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           if (!isBackground) {
               System.exit(0);
           }
       }
    }
}