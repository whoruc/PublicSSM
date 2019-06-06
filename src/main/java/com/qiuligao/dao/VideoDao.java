package com.qiuligao.dao;

import com.qiuligao.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author l
 */
public interface VideoDao {

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
    void uploadVideos(@Param(value = "name") String name, @Param(value = "time") Timestamp time,
                      @Param(value = "length") int length, @Param(value = "position") String position,
                      @Param(value = "filePosition") String filePosition, @Param(value = "cameraID") int cameraID);
}
