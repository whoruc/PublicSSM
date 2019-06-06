package com.qiuligao.service;

import com.qiuligao.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author l
 */
public interface VideoService {

    /**
     * 通过camera找到所有的录像
     * @param id
     * @return
     */
    List<Video> getVideoByCameraId(int id);

    /**
     * 插入上传的video信息
     * @param name
     * @param time
     * @param length
     * @param position
     * @param filePosition
     * @param cameraID
     */
    void uploadVideos(String name, Timestamp time, int length, String position, String filePosition, int cameraID);
}
