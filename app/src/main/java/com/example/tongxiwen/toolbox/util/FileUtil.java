package com.example.tongxiwen.toolbox.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by tong.xiwen on 2017/8/28.
 * TODO 待完善
 */
public class FileUtil {
    private static final String TAG = "FileUtil";
    private Context context;

    public FileUtil(Context context) {
        this.context = context;
    }

    /**
     * 写入文件
     *
     * @param value 数据
     * @param file  文件名
     *              不支持long
     */
    public void writeToFile(String file, String key, Object value) {
        if (checkParamsIsNull(file, key, value)) {
//            Log.e(TAG, new LogUtil.DebugInfo() +"参数为空");
            return;
        }
        SharedPreferences.Editor editor = context.getSharedPreferences(file, Context.MODE_PRIVATE).edit();
        if (value instanceof Integer) {
            editor.putInt(key, (int) value);
        }
        if (value instanceof String) {
            editor.putString(key, (String) value);
        }
        if (value instanceof Boolean) {
            editor.putBoolean(key, (boolean) value);
        }
        if (value instanceof Float) {
            editor.putFloat(key, (float) value);
        }
        editor.apply();
    }

    /**
     * 写入Long到文件
     *
     * @param file  文件名
     * @param key   数据名
     * @param value 数据
     */
    public void writeLongToFile(String file, String key, long value) {
        if (checkParamsIsNull(file, key)) {
//            Log.e(TAG, new LogUtil.DebugInfo() + "参数为空");
            return;
        }
        SharedPreferences.Editor editor = context.getSharedPreferences(file, Context.MODE_PRIVATE).edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * 获取字符串
     *
     * @param file 文件名
     * @param key  数据
     * @return 默认返回空字符串
     */
    public String readStringFromFile(String file, String key) {
        if (checkParamsIsNull(file, key)) {
//            Log.e(TAG, new LogUtil.DebugInfo() + "参数为空");
            return "";
        }
        SharedPreferences perf = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        return perf.getString(key, "");
    }

    /**
     * 获取Boolean
     *
     * @param file 文件名
     * @param key  数据名
     * @return 默认返回false
     */
    public boolean readBolleanFromFile(String file, String key) {
        if (checkParamsIsNull(file, key)) {
//            Log.e(TAG, new LogUtil.DebugInfo() + "参数为空");
            return false;
        }
        SharedPreferences perf = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        return perf.getBoolean(key, false);
    }

    /**
     * 获取整形
     *
     * @param file 文件名
     * @param key  数据名
     * @return 默认返回0
     */
    public int readIntegerFromFile(String file, String key) {
        if (checkParamsIsNull(file, key)) {
//            Log.e(TAG, new LogUtil.DebugInfo() + "参数为空");
            return 0;
        }
        SharedPreferences perf = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        return perf.getInt(key, 0);
    }

    /**
     * 获取浮点数
     *
     * @param file 文件名
     * @param key  数据名
     * @return 默认返回0
     */
    public float readFloatFromFile(String file, String key) {
        if (checkParamsIsNull(file, key)) {
//            Log.e(TAG, new LogUtil.DebugInfo() + "参数为空");
            return 0;
        }
        SharedPreferences perf = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        return perf.getFloat(key, 0);
    }

    /**
     * 获取长整形
     *
     * @param file 文件名
     * @param key  数据名
     * @return 默认返回0
     */
    public long readLongFromFile(String file, String key) {
        if (checkParamsIsNull(file, key)) {
//            Log.e(TAG, new LogUtil.DebugInfo() + "参数为空");
            return 0;
        }
        SharedPreferences perf = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        return perf.getLong(key, 0);
    }

    /**
     * 判断参数是否为空
     *
     * @param os 参数集
     * @return 若有空则为true
     */
    private boolean checkParamsIsNull(Object... os) {
        for (Object o : os) {
            if (o == null) {
                return false;
            }
        }
        return true;
    }
}
