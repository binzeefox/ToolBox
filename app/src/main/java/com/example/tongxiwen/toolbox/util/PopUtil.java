package com.example.tongxiwen.toolbox.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by tong.xiwen on 2017/8/18.
 * 弹出提示相关
 */
public class PopUtil {

    private Context mContext;
    private Toast mToast;
    private AlertDialog mDialog;

    public PopUtil(Context context){
        mContext = context;
    }

    /**
     * 显示Toast，如果已存在Toast则直接更改显示的Toast的文字
     * @param text  文字
     */
    public void showToast(CharSequence text){
        if (mToast != null){
            mToast.setText(text);
            return;
        }
        mToast = Toast.makeText(mContext, text, Toast.LENGTH_LONG);
        mToast.show();
    }
    public void showToast(int resourceId){
        String text = mContext.getString(resourceId);
        showToast(text);
    }

    /**
     * 显示确认信息弹窗
     * @param text  信息
     * @param confirmListener 确认按钮点击回调
     * @param themeResource 风格资源
     */
    public void showConfirmDialog(CharSequence text, DialogInterface.OnClickListener confirmListener, int themeResource){
        AlertDialog.Builder builder;
        if (themeResource != -1) {
            builder = new AlertDialog.Builder(mContext, themeResource);
        }else builder = new AlertDialog.Builder(mContext);

        builder.setTitle("请确认");
        builder.setCancelable(false);
        builder.setMessage(text);
        builder.setPositiveButton("确定", confirmListener);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDialog.dismiss();
                mDialog = null;
            }
        });
        mDialog = builder.show();
    }
    public void showConfirmDialog(CharSequence text, DialogInterface.OnClickListener confirmListener){
        showConfirmDialog(text, confirmListener, -1);
    }


}
