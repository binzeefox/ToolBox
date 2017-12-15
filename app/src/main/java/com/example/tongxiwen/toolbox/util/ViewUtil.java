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
 */
public class ViewUtil {

    private View root;
    private Context mContext;

    public ViewUtil(View rootView){
        this(rootView.getContext());
        root = rootView;
    }

    public ViewUtil(Context context){
        mContext = context;
    }

    /**
     * 在Activity中通过ID获取部件
     * @param resourceId 部件id
     * @param <T>   部件类
     * @return  部件
     */
    public <T extends View> T findViewById(@IdRes int resourceId){
        //noinspection unchecked
        return (T) ((Activity)mContext).findViewById(resourceId);
    }

    /**
     * 在Fragment中通过ID获取部件
     * @param resourceId    部件id
     * @param <T>   部件类
     * @return  部件
     */
    public <T extends View> T findViewByIdFromView(@IdRes int resourceId){
        //noinspection unchecked
        return (T) root.findViewById(resourceId);
    }
}
