package com.qiuligao.service;

import com.qiuligao.entity.Camera;
import com.qiuligao.entity.Guard;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 由摄像头id得到最近的保安
     * @param id
     * @return
     */
    List<Guard> getNearestGuard(int id);

    /**
     * 增加对应摄像头的超标次数
     * @param id
     */
    void addExcreedTimes(int id);

    /**
     * 获取所有保安的信息
     * @return
     */
    List<Guard> getAllGuards();
}
