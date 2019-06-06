package com.qiuligao.dao;

import com.qiuligao.entity.Camera;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author l
 */
public interface CameraDao {

    /**
     * 通过id找到camera
     * @param id
     * @return
     */
    Camera findCameraById(int id);

    /**
     * 修改摄像头的threshold
     * @param id
     * @param threshold
     * @return
     */
    void modifyThreshold(@Param("id") int id, @Param("threshold") int threshold);

    /**
     * 得到所有摄像头信息
     * @return
     */
    List<Camera> getAllCamera();
}
