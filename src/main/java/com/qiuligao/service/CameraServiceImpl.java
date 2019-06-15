package com.qiuligao.service;

import com.qiuligao.dao.CameraDao;
import com.qiuligao.dao.GuardDao;
import com.qiuligao.entity.Camera;
import com.qiuligao.entity.Guard;
import com.qiuligao.util.ConfigUtil;
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

    @Resource
    GuardDao guardDao;

    public Camera findCameraById(int id) {
        return cameraDao.findCameraById(id);
    }

    public void modifyThreshold(int id, int threshold) {
        cameraDao.modifyThreshold(id, threshold);
    }

    public List<Camera> getAllCamera() {
        return cameraDao.getAllCamera();
    }

    public List<Guard> getNearestGuard(int id) {
        Camera camera = cameraDao.findCameraById(id);
        double longitude = camera.getLongitude();
        double latitude = camera.getLatitude();

        return guardDao.getNearestGuard(longitude, latitude);
    }

    public void addExcreedTimes(int id) {
        cameraDao.addExcreedTimes(id);
    }

    public List<Guard> getAllGuards() {
        return guardDao.getAllGuards();
    }

    public void modifyOption(int option) {
        ConfigUtil.setCameraOption(option);
    }

    public void modifyParam(int id, int param) {
        cameraDao.modifyParam(id, param);
    }

    public int getCameraOption() {
        return ConfigUtil.getCameraOption();
    }
}
