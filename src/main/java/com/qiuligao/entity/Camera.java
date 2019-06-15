package com.qiuligao.entity;

import java.math.BigDecimal;

/**
 * @author l
 */
public class Camera {
    int id;
    String position;
    int threshold;
    Double longitude;
    Double latitude;
    int times;
    int param;

    public int getTimes() {
        return times;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public int getThreshold() {
        return threshold;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }
}
