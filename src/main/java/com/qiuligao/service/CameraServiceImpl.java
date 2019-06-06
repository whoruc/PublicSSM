package com.qiuligao.service;

import com.qiuligao.dao.CameraDao;
import com.qiuligao.entity.Camera;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author
 */
@Service("cameraService")
public class CameraServiceImpl implements CameraService {

    @Resource
    CameraDao cameraDao;

    public Camera findCameraById(int id) {
        return cameraDao.findCameraById(id);
    }

    public void modifyThreshold(int id, int threshold) {
        cameraDao.modifyThreshold(id, threshold);
    }

    public List<Camera> getAllCamera() {
        return cameraDao.getAllCamera();
    }
}
