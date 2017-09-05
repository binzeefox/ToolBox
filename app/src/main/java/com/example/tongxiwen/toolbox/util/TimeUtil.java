package com.example.tongxiwen.toolbox.util;

/**
 * Created by tong.xiwen on 2017/8/18.
 * 时间
 * 相关
 */
public class TimeUtil {

    /**
     * 返回毫秒数
     * @param h 小时
     * @param m 分钟
     * @param s 秒
     * @return long类型毫秒数
     */
    public static long getMSecond(int h, int m, int s){
        return h * 3600000 + m * 60000 + s * 1000;
    }
    public static long getMSecond(int m, int s){
        return getMSecond(0, m, s);
    }
    public static long getMSecondByH(int h){
        return getMSecond(h, 0, 0);
    }
    public static long getMSecondByM(int m){
        return getMSecond(0, m, 0);
    }

    /**
     * 通过毫秒获取小时
     * @param ms    毫秒
     * @return  小时
     */
    public static int getHour(int ms){
        return ms / 3600000;
    }

    /**
     * 通过毫秒获取分钟
     * @param ms    毫秒
     * @return  分钟
     */
    public static int getMinite(int ms){
        return ms / 60000;
    }

    /**
     * 通过毫秒获取秒
     * @param ms    毫秒
     * @return  秒
     */
    public static int getSecond(int ms){
        return ms / 1000;
    }
}
