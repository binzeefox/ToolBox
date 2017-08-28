package com.example.tongxiwen.toolbox.util;

/**
 * Created by tong.xiwen on 2017/8/22.
 * 最普遍的util，等待积累
 */
public class CommonUtil {

    /**
     * 通过StringBuilder拼接字符串
     * @param strs
     * @return
     */
    public static String appendStr(String ... strs){
        StringBuilder builder = new StringBuilder();
        for (String str : strs){
            builder.append(str);
        }
        return builder.toString();
    }
}
