package com.example.tongxiwen.toolbox.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.tongxiwen.toolbox.MainActivity;
import com.example.tongxiwen.toolbox.R;

/**
 * Created by tong.xiwen on 2017/8/18.
 * View相关，好像更麻烦了？
 */
public class ViewUtil {

    /**
     * 在Activity中通过ID获取部件
     * @param context Activity
     * @param resourceId 部件id
     * @param <T>   部件类
     * @return  部件
     */
    public static <T extends View> T findViewById(@NonNull Activity context, @IdRes int resourceId){
        //noinspection unchecked
        return (T) context.findViewById(resourceId);
    }

    /**
     * 在Fragment中通过ID获取部件
     * @param view  根View
     * @param resourceId    部件id
     * @param <T>   部件类
     * @return  部件
     */
    public static <T extends View> T findViewById(@NonNull View view, @IdRes int resourceId){
        //noinspection unchecked
        return (T) view.findViewById(resourceId);
    }

    /**
     * 获取index位置下ViewGroup的子控件
     * @param viewGroup 父控件
     * @param index 角标
     * @param <T>   类型
     * @return  子部件
     */
    public static <T extends  View> T getViewFromGroup(@NonNull View viewGroup, @IdRes int index){
        if (!(viewGroup instanceof ViewGroup)){
            return null;
        }
        //noinspection unchecked
        return (T) ((ViewGroup) viewGroup).getChildAt(index);
    }

    /**
     * 为继承自TextView的部件设置文字
     * @param view  部件
     * @param text  文字
     * @param <T>   类型
     */
    public static <T extends TextView> void text(@NonNull T view, String text){
        view.setText(text);
    }

    /**
     * 获取继承自TextView的部件的文字
     * @param view  部件
     * @param <T>   类型
     * @return  文字
     */
    public static <T extends TextView> String text(@NonNull T view){
        return (String) view.getText();
    }
}
