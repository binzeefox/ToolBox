package com.example.tongxiwen.toolbox.util;

import android.util.Log;

/**
 * Created by tong.xiwen on 2017/8/21.
 * 若不想打印，可将isPrint 设置成false
 */
@SuppressWarnings("ConstantConditions")
public class LogUtil {


    private final boolean isPrint = true;   // TODO 若打印则为true，若停止打印则为false

    public void v(CharSequence tag, CharSequence message) {
        if (isPrint) {
            Log.v((String) tag, (String) message);
        }
    }

    public void d(CharSequence tag, CharSequence message) {
        if (isPrint) {
            Log.d((String) tag, (String) message);
        }
    }

    public void i(CharSequence tag, CharSequence message) {
        if (isPrint) {
            Log.i((String) tag, (String) message);
        }
    }

    public void w(CharSequence tag, CharSequence message) {
        if (isPrint) {
            Log.w((String) tag, (String) message);
        }
    }

    public void e(CharSequence tag, CharSequence message) {
        if (isPrint) {
            Log.e((String) tag, (String) message);
        }
    }

    /**
     * 用于显示代码位置和行号与方法名
     */
    public static class DebugInfo extends Exception {
        public String line() {
            StackTraceElement[] trace = getStackTrace();
            if (trace == null || trace.length == 0) {
                return String.valueOf(-1);
            }
            return "(" + trace[0].getFileName() + ":" + String.valueOf(trace[0].getLineNumber()) + ")";
        }

        public String fun() {
            StackTraceElement[] trace = getStackTrace();
            if (trace == null || trace.length == 0) {
                return "";
            }
            return trace[0].getMethodName();
        }

        public DebugInfo() {
            super();
        }

        @Override
        public String toString() {
            return line() + fun();
        }
    }
}
