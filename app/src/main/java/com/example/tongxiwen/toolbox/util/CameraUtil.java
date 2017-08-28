package com.example.tongxiwen.toolbox.util;

import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;

import java.util.List;

/**
 * Created by tong.xiwen on 2017/8/23.
 * 使用的旧版Camera类
 */
public class CameraUtil {

    private Camera mCamera;

    public CameraUtil(Camera camera){
        mCamera = camera;
    }

    /**
     * 判断是否拥有相机
     * @param ctx   目标context
     * @return  是否拥有
     */
    public static boolean hasCameraDevice(Context ctx){
        return ctx.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    /**
     * 判断是否能自动对焦
     * @return  是否能自动对焦
     */
    public boolean isAutoFocusSupported(){
        Camera.Parameters parameters = mCamera.getParameters();
        List<String> modes = parameters.getSupportedFocusModes();
        return modes.contains(Camera.Parameters.FOCUS_MODE_AUTO);
    }

    /**
     * 设置相机跟随activity页面方向
     * @param context   目标Context
     */
    public void followScreenOrientation(Context context){
        final int orientation = context.getResources().getConfiguration().orientation;
        switch (orientation){
            case Configuration.ORIENTATION_LANDSCAPE:
                mCamera.setDisplayOrientation(180);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                mCamera.setDisplayOrientation(90);
                break;
            default:
                break;
        }
    }
}
