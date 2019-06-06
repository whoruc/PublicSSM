package com.qiuligao.service;

import com.qiuligao.entity.Camera;

import java.util.List;

/**
 * @author l
 */
public interface CameraService {

    /**
     * 通过id找到camera
     * @param id
     * @return
     */
    Camera findCameraById(int id);

    /**
     * 修改camera的阈值
     * @param id
     * @param threshold
     * @return
     */
    void modifyThreshold(int id, int threshold);

    /**
     * 得到所有摄像头信息
     * @return
     */
    List<Camera> getAllCamera();
}
