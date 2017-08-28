package com.example.tongxiwen.toolbox.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by tong.xiwen on 2017/8/18.
 * 弹出提示相关
 */
public class PopUtil {


    /**
     * 显示Toast，如果已存在Toast则直接更改显示的Toast的文字
     * @param context   目标
     * @param text  文字
     */
    private Toast toast;
    public void showToast(Context context, CharSequence text){
        if (toast != null){
            toast.setText(text);
            return;
        }
        toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.show();
    }
    public void showToast(Context context, int resourceId){
        String text = context.getString(resourceId);
        showToast(context, text);
    }
}
