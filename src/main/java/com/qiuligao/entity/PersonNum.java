package com.qiuligao.entity;

/**
 * @author l
 */
public class PersonNum {
    int nums;
    int camera_id;
    int threshold;

    String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getNums() {
        return nums;
    }

    public int getCameraID() {
        return camera_id;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public void setCameraID(int cameraID) {
        this.camera_id = cameraID;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
