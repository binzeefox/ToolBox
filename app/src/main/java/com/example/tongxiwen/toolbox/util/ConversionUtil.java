package com.example.tongxiwen.toolbox.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by tong.xiwen on 2017/8/22.
 * 单位util，专门为单位转换
 */
public class ConversionUtil {

    private Context mContext;

    public ConversionUtil(Context context){
        mContext = context;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public int px2dip(float pxValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据手机分辨率从 sp 转为 px
     */
    public int Sp2Px(int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, mContext.getResources().getDisplayMetrics());
    }

    /**
     * 根据手机分辨率从 px 转为 sp
     */
    public int Px2Sp(int px) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, mContext.getResources().getDisplayMetrics());
    }

    /**
     * 获取手机宽高像素
     */
    public int[] getScreenSize(Activity activity){
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        return new int[]{width, height};
    }
}
