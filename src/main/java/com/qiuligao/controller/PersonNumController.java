package com.qiuligao.controller;

import com.alibaba.fastjson.JSON;
import com.qiuligao.dao.CameraDao;
import com.qiuligao.entity.Camera;
import com.qiuligao.entity.PersonNum;
import com.qiuligao.service.CameraService;
import com.qiuligao.service.PersonNumService;
import com.qiuligao.util.ConfigUtil;
import jdk.nashorn.internal.scripts.JO;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author l
 */
@Controller
@RequestMapping("")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonNumController {

    @Resource
    PersonNumService personNumService;

    @Resource
    CameraService cameraService;

    /**
     * 通过所有num信息
     *
     * @return
     */
    @RequestMapping(value = "/getAllNums", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllNums() {
        List<PersonNum> list = personNumService.getAllNums();
        return JSON.toJSONString(list);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadPicAndNum", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public String uploadPicture(@RequestParam("files") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                String[] after = fileName.split("_");
                int id = Integer.parseInt(after[0]);
                int nums = Integer.parseInt(after[1]);
                String filePath = ConfigUtil.getFilePath(id);
                String url = filePath + fileName;
                File storeFile = new File(url);

                if (!storeFile.exists()) {
                    storeFile.mkdirs();
                }

                file.transferTo(new File(url));
                String webUrl = ConfigUtil.getPath(id) + fileName;
                switch (id) {
                    case 1:
                        ConfigUtil.setLastNameC1(webUrl, url);
                        break;
                    case 2:
                        ConfigUtil.setLastNameC2(webUrl, url);
                        break;
                    case 3:
                        ConfigUtil.setLastNameC3(webUrl, url);
                        break;
                    default:
                        return "unKnow ID";
                }

                personNumService.updateNumsById(id, nums);
                Camera camera = cameraService.findCameraById(id);
                return JSON.toJSONString(camera.getThreshold());

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return "file is empty";
        }
        return "param error";
    }
}
