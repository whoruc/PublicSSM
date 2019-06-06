package com.qiuligao.service;

import com.qiuligao.dao.VideoDao;
import com.qiuligao.entity.Video;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author
 */
@Service("videoService")
public class VideoServiceImpl implements VideoService {

    @Resource
    VideoDao videoDao;

    public List<Video> getVideoByCameraId(int id) {
        return videoDao.getVideoByCameraId(id);
    }

    public void uploadVideos(String name, Timestamp time, int length, String position, String filePosition, int cameraID) {
        videoDao.uploadVideos(name, time, length, position, filePosition, cameraID);
    }
}
