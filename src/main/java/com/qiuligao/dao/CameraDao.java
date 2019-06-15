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

    /**
     * 增加对应摄像头的超标次数
     * @param id
     */
    void addExcreedTimes(int id);

    /**
     * 获取标注状态
     * @return
     */
    int getCameraOption();

    /**
     * 更改摄像头参数
     * @param id
     * @param param
     */
    void modifyParam(@Param("id") int id, @Param("param") int param);
}
