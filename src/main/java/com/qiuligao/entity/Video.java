package com.qiuligao.entity;

import java.sql.Timestamp;

/**
 * @author l
 */
public class Video {
    int id;
    String name;
    Timestamp time;
    int length;
    String position;
    String file_position;

    public void setFilePosition(String filePosition) {
        this.file_position = filePosition;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilePosition() {
        return file_position;
    }

    public String getPosition() {
        return position;
    }

    public int getLength() {
        return length;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
