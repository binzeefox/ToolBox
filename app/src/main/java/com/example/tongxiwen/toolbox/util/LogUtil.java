package com.example.tongxiwen.toolbox.util;

import android.util.Log;

/**
 * Created by tong.xiwen on 2017/8/21.
 * 若不想打印，可将isPrint 设置成false
 */
@SuppressWarnings("ConstantConditions")
public class LogUtil {


    private final boolean isPrint = true;   // TODO 若打印则为true，若停止打印则为false

    public void v(CharSequence tag, CharSequence message){
        if (isPrint) {
            Log.v((String) tag, (String) message);
        }
    }

    public void d(CharSequence tag, CharSequence message){
        if (isPrint) {
            Log.d((String) tag, (String) message);
        }
    }

    public void i(CharSequence tag, CharSequence message){
        if (isPrint) {
            Log.i((String) tag, (String) message);
        }
    }

    public void w(CharSequence tag, CharSequence message){
        if (isPrint) {
            Log.w((String) tag, (String) message);
        }
    }

    public void e(CharSequence tag, CharSequence message){
        if (isPrint) {
            Log.e((String) tag, (String) message);
        }
    }
}
