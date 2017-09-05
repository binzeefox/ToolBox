package com.example.tongxiwen.toolbox.util;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by tong.xiwen on 2017/9/5.
 */
public class ProcessUtil {

    /**
     * 判断进程是否存活
     * @param context
     * @param proessName
     */
    public static boolean isProessRunning(Context context, String proessName) {
        boolean isRunning = false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        List<ActivityManager.RunningAppProcessInfo> lists = am.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo info : lists) {
            if (info.processName.equals(proessName)) {
                isRunning = true;
            }
        }

        return isRunning;
    }
}
