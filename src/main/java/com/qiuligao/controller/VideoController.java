package com.qiuligao.controller;

import com.alibaba.fastjson.JSON;
import com.qiuligao.entity.Camera;
import com.qiuligao.entity.Video;
import com.qiuligao.service.CameraService;
import com.qiuligao.service.VideoService;
import com.qiuligao.util.ConfigUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author l
 */
@Controller
@RequestMapping("")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VideoController {
    @Resource
    VideoService videoService;

    @Resource
    CameraService cameraService;

    @RequestMapping(value = "/getVideo", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getVideoByCameraId(@RequestParam(value = "id") int id) {
        List<Video> videos = videoService.getVideoByCameraId(id);
        return JSON.toJSONString(videos);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadVideo", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public String uploadPicture(@RequestParam("files") MultipartFile file) {
        long size = file.getSize();
        int MAX = 1024 * 2;
        String fileName = file.getOriginalFilename();
        if (!file.isEmpty()) {
            if (size < MAX) {
                return "file < 200kb";
            }
            try {
                String[] after = fileName.split("_");
                String time = after[0];
                String[] temp = after[1].split("\\.");
                long longTime;
                try {
                    longTime = Long.parseLong(time);
                } catch (Exception e) {
                    return "false timestamp";
                }
                int id = Integer.parseInt(temp[0]);
                Camera camera = cameraService.findCameraById(id);
                String position = camera.getPosition();
                String storeFileName = time + "." + temp[1];
                String filePath = ConfigUtil.getVideoFilePath(id);
                String webPath = ConfigUtil.getVideoPath(id);
                String url = filePath + storeFileName;
                String webUrl = webPath + storeFileName;
                File storeFile = new File(url);

                if (!storeFile.exists()) {
                    storeFile.mkdirs();
                }

                file.transferTo(new File(url));
                videoService.uploadVideos(storeFileName, new Timestamp(longTime), 400, position, webUrl, id);
                return "1";
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return "file is empty";
        }
        return "param error";
    }
}
