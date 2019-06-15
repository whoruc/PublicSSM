package com.qiuligao.util;

import com.qiuligao.entity.Camera;

/**
 * @author l
 */
public class CameraMessage {
    static volatile private int totalNums1 = 0;
    static volatile private int totalNums2 = 0;
    static volatile private int totalNums3 = 0;

    static volatile private int count1 = 0;
    static volatile private int count2 = 0;
    static volatile private int count3 = 0;

    public static void addTotalNumsAndCount(int id, int num) {
        switch (id) {
            case 1:
                totalNums1 += num;
                count1++;
                break;
            case 2:
                totalNums2 += num;
                count2++;
                break;
            case 3:
                totalNums3 += num;
                count3++;
                break;
            default:
                break;
        }
    }

    public static int getTotalNums1() {
        return totalNums1;
    }

    public static int getTotalNums2() {
        return totalNums2;
    }

    public static int getTotalNums3() {
        return totalNums3;
    }

    public static int getCount1() {
        return count1;
    }

    public static int getCount2() {
        return count2;
    }

    public static int getCount3() {
        return count3;
    }

    public static void setTotalNums1(int totalNums1) {
        CameraMessage.totalNums1 = totalNums1;
    }

    public static void setTotalNums2(int totalNums2) {
        CameraMessage.totalNums2 = totalNums2;
    }

    public static void setTotalNums3(int totalNums3) {
        CameraMessage.totalNums3 = totalNums3;
    }

    public static void setCount1(int count1) {
        CameraMessage.count1 = count1;
    }

    public static void setCount2(int count2) {
        CameraMessage.count2 = count2;
    }

    public static void setCount3(int count3) {
        CameraMessage.count3 = count3;
    }
}
