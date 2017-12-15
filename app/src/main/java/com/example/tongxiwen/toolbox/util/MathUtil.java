package com.example.tongxiwen.toolbox.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by tong.xiwen on 2017/8/18.
 * 数学相关，别烦我
 */
public class MathUtil {

    /**
     * 判断奇偶
     * @param num 数字
     * @return  返回true为奇数
     */
    public static boolean checkIsObb(int num){
        // 基数与1等于1， 偶数与1等于0
        return (num & 1) != 0;
    }

    /**
     * 判断质数
     * @param num
     * @return
     */
    public static boolean checkIsPrime(int num){
        num = Math.abs(num);
        switch (num){
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                for (int i = 2; i < num; i++){
                    if (num%i == 0){
                        return false;
                    }
                }
                return true;
        }
    }

    /**
     * 获取一串数字中最大的
     * @param nums  数字串
     * @return  最大数
     */
    public static int getMaxNum(int ... nums){
        int max = nums[0];
        for (int num : nums){
            max = Math.max(max, num);
        }
        return max;
    }

    /**
     * 获取一串数字中最小值
     * @param nums  数字串
     * @return  最小值
     */
    public static int getMinNum(int ... nums){
        int min = nums[0];
        for (int num : nums){
            min = Math.min(min, num);
        }
        return min;
    }

    /**
     * 列表升序排序
     */
    public static List<Integer> upCountNums(int... nums){
        List<Integer> list = new ArrayList<>();
        for (int i : nums){
            list.add(i);
        }
        return upCountNums(list);
    }
    public static List<Integer> upCountNums(Collection<Integer> nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            int num = Collections.min(nums);
            list.add(i);
        }
        return list;
    }

    /**
     * 列表降序排序
     * @deprecated
     * fixme 逻辑错误
     */
    public static List<Integer> downCountNums(int... nums){
        List<Integer> list = new ArrayList<>();
        for (int i : nums){
            list.add(i);
        }
        return downCountNums(list);
    }
    public static List<Integer> downCountNums(Collection<Integer> nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            int num = Collections.max(nums);
            list.add(i);
        }
        return list;
    }

    /**
     * 判断自然数是否是某数的平方
     */
    private boolean checkSquare(int num){
        int l = 0;
        int r = num;

        while(l<=r){
            int m = (l+r)/2;
            int s = m * m;

            if(s == num){
                return true;
            } else if(s < num){
                l = m + 1;
            } else{
                r = m - 1;
            }
        }
        return false;
    }
}
