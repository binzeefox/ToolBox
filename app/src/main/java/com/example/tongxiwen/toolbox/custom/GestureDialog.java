package com.example.tongxiwen.toolbox.custom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.example.tongxiwen.toolbox.R;

/**
 * Created by tong.xiwen on 2017/12/14.
 * 获取手势的AlertDialog
 * 通过回调（Builder.OnClickListener）获取Gesture对象
 */
public class GestureDialog extends AlertDialog{

    protected GestureDialog(Context context) {
        super(context);
    }
    protected GestureDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    protected GestureDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder extends AlertDialog.Builder {
        GestureOverlayView view;
        OnClickListener listener;
        Gesture gesture;

        Builder(Context context) {
            super(context);
            View view = LayoutInflater.from(context).inflate(R.layout.gesture_dialog_view, null);
            this.view = view.findViewById(R.id.dialog_gesture_view);
            this.view.addOnGesturePerformedListener(gesturePerformedListener);
            this.view.addOnGesturingListener(gesturingListener);
            this
                    .setTitle("请绘制手势")
                    .setView(view)
                    .setCancelable(false)
                    .setNegativeButton(android.R.string.cancel, null)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (listener != null) {
                                listener.onClick(dialog, which, gesture);
                            }
                        }
                    });
        }

        GestureOverlayView getGestureView() {
            return view;
        }

        void setPositiveButtonListener(OnClickListener listener) {
            this.listener = listener;
        }

        interface OnClickListener {
            void onClick(DialogInterface dialog, int which, Gesture gesture);
        }

        GestureOverlayView.OnGesturePerformedListener gesturePerformedListener = new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                Builder.this.gesture = gesture;
            }
        };

        GestureOverlayView.OnGesturingListener gesturingListener = new GestureOverlayView.OnGesturingListener() {
            Bitmap bitmap;
            @Override
            public void onGesturingStarted(GestureOverlayView overlay) {
                ImageView imageView = overlay.findViewById(R.id.img_preview);
                imageView.setVisibility(View.GONE);
                imageView.setImageBitmap(null);
                overlay.destroyDrawingCache();
                bitmap = null;
            }

            @Override
            public void onGesturingEnded(GestureOverlayView overlay) {
                ImageView imgView = overlay.findViewById(R.id.img_preview);
                overlay.setDrawingCacheEnabled(true);
                overlay.buildDrawingCache();
                bitmap = overlay.getDrawingCache(true);
                imgView.setImageBitmap(bitmap);
                imgView.setVisibility(View.VISIBLE);
            }
        };
    }
}
