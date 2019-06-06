package com.qiuligao.util;

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
    private static String fileMenu = "/var/lib/tomcat/webapps/ROOT/";
    private static String menu = "120.77.87.148:8080/";

    private static volatile String lastNameC1 = "1";
    private static volatile String lastNameC2 = "2";
    private static volatile String lastNameC3 = "3";

//    Lock readLock = new ReentrantReadWriteLock.ReadLock();
//    Lock writeLock = new ReentrantReadWriteLock.WriteLock();

    private static LinkedBlockingQueue<String> nameC1 = new LinkedBlockingQueue<String>(6);
    private static LinkedBlockingQueue<String> nameC2 = new LinkedBlockingQueue<String>(6);
    private static LinkedBlockingQueue<String> nameC3 = new LinkedBlockingQueue<String>(6);

    public static synchronized void setLastNameC1(String name, String fileName) {
        lastNameC1 = name;
        if (nameC1.size() == 5) {
            try {
                File file = new File(nameC1.take());
                if (file.exists()) {
                    file.delete();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            nameC1.put(fileName);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized  void setLastNameC2(String name, String fileName) {
        lastNameC2 = name;
        if (nameC2.size() == 5) {
            try {
                File file = new File(nameC2.take());
                if (file.exists()) {
                    file.delete();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            nameC2.put(fileName);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized  void setLastNameC3(String name, String fileName) {
        lastNameC3 = name;
        if (nameC3.size() == 5) {
            try {
                File file = new File(nameC3.take());
                if (file.exists()) {
                    file.delete();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            nameC3.put(fileName);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            case 1 : return fileMenu + "pic_1/";
            case 2 : return fileMenu + "pic_2/";
            case 3 : return fileMenu + "pic_3/";
            default: break;
        }
        return null;
    }

    public static String getPath(int id) {
        switch (id) {
            case 1 : return menu + "pic_1/";
            case 2 : return menu + "pic_2/";
            case 3 : return menu + "pic_3/";
            default: break;
        }
        return null;
    }

    public static String getVideoFilePath(int id) {
        switch (id) {
            case 1 : return fileMenu + "camera_1/";
            case 2 : return fileMenu + "camera_2/";
            case 3 : return fileMenu + "camera_3/";
            default: break;
        }
        return null;
    }

    public static String getVideoPath(int id) {
        switch (id) {
            case 1 : return menu + "camera_1/";
            case 2 : return menu + "camera_2/";
            case 3 : return menu + "camera_3/";
            default: break;
        }
        return null;
    }
}
