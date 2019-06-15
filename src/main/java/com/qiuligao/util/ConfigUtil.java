package com.qiuligao.util;

import com.qiuligao.dao.CameraDao;
import com.qiuligao.service.CameraService;

import javax.annotation.Resource;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author l
 */
public class ConfigUtil {

    private static int cameraOption = 0;

    private static String fileMenu = "/var/lib/tomcat/webapps/ROOT/";
    private static String menu = "120.77.87.148:8080/";

    private static volatile String lastNameC1 = "1";
    private static volatile String lastNameC2 = "2";
    private static volatile String lastNameC3 = "3";

    private static int threshold1 = 0;
    private static int threshold2 = 0;
    private static int threshold3 = 0;

    public static synchronized void setLastNameC1(String name, String fileName) {
        lastNameC1 = name;
    }

    public static synchronized  void setLastNameC2(String name, String fileName) {
        lastNameC2 = name;
    }

    public static synchronized  void setLastNameC3(String name, String fileName) {
        lastNameC3 = name;
//        if (nameC3.size() == 5) {
//            try {
//                File file = new File(nameC3.take());
//                if (file.exists()) {
//                    file.delete();
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            nameC3.put(fileName);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static String getLastNameC1() {
        return lastNameC1;
    }

    public static String getLastNameC2() {
        return lastNameC2;
    }

    public static String getLastNameC3() {
        return lastNameC3;
    }

    public static String getFilePath(int id) {
        switch (id) {
            case 1 :
                return fileMenu + "pic_1/";
            case 2 :
                return fileMenu + "pic_2/";
            case 3 :
                return fileMenu + "pic_3/";
            default:
                break;
        }
        return null;
    }

    public static String getPath(int id) {
        switch (id) {
            case 1 :
                return menu + "pic_1/";
            case 2 :
                return menu + "pic_2/";
            case 3 :
                return menu + "pic_3/";
            default:
                break;
        }
        return null;
    }

    public static String getVideoFilePath(int id) {
        switch (id) {
            case 1 :
                return fileMenu + "camera_1/";
            case 2 :
                return fileMenu + "camera_2/";
            case 3 :
                return fileMenu + "camera_3/";
            default:
                break;
        }
        return null;
    }

    public static String getVideoPath(int id) {
        switch (id) {
            case 1 :
                return menu + "camera_1/";
            case 2 :
                return menu + "camera_2/";
            case 3 :
                return menu + "camera_3/";
            default:
                break;
        }
        return null;
    }

    public static int getCameraOption() {
        return cameraOption;
    }

    public static void setCameraOption(int option) {
        cameraOption = option;
    }

    public static int getThreshold1() {
        return threshold1;
    }

    public static int getThreshold2() {
        return threshold2;
    }

    public static int getThreshold3() {
        return threshold3;
    }

    public static void setThreshold1(int threshold1) {
        ConfigUtil.threshold1 = threshold1;
    }

    public static void setThreshold2(int threshold2) {
        ConfigUtil.threshold2 = threshold2;
    }

    public static void setThreshold3(int threshold3) {
        ConfigUtil.threshold3 = threshold3;
    }
}
