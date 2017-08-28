package com.example.tongxiwen.toolbox.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by tong.xiwen on 2017/8/28.
 * 必须实例化
 * 只能监听单一传感器
 * 必须调用sensorWork（false），否则无法释放传感器
 */
public class SensorUtil {

    public static final int FOR_UI = SensorManager.SENSOR_DELAY_UI;
    public static final int FOR_NORMAL = SensorManager.SENSOR_DELAY_NORMAL;
    public static final int FOR_GAME = SensorManager.SENSOR_DELAY_GAME;
    public static final int FOR_FASTEST = SensorManager.SENSOR_DELAY_FASTEST;
    private int sensorDelay;

    private SensorManager mManager;
    private Sensor mSensor;
    private int sensorType;
    private OnValueChangedListener valueListener;

    private float[] values;

    public SensorUtil(Context context, int sensorType, int sensorDelay){
        this.sensorType = sensorType;
        this.sensorDelay = sensorDelay;

        mManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mManager.getDefaultSensor(sensorType);
        valueListener = new OnValueChangedListener() {
            @Override
            public void onChange(Sensor sensor, float[] values) {

            }
        };
    }

    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
           if (event.sensor.getType() == sensorType){
               values = event.values;
               valueListener.onChange(event.sensor, event.values);

           }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    /**
     * 传感器开关
     * @param isWorking 若为false，则关闭传感器
     */
    public void sensorWork(boolean isWorking){
        if (isWorking){
            mManager.registerListener(listener, mSensor, sensorDelay);
        }else {
            mManager.unregisterListener(listener);
        }
    }

    /**
     * 返回传感器当前信息
     */
    public float[] getValues(){
        return values;
    }

    /**
     * 传感器监听器
     */
    public interface OnValueChangedListener{
        void onChange(Sensor sensor, float[] values);
    }
}
