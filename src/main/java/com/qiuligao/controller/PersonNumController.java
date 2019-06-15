package com.qiuligao.controller;

import com.alibaba.fastjson.JSON;
import com.qiuligao.dao.CameraDao;
import com.qiuligao.entity.Camera;
import com.qiuligao.entity.PersonNum;
import com.qiuligao.service.CameraService;
import com.qiuligao.service.PersonNumService;
import com.qiuligao.util.CameraMessage;
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
import java.sql.Timestamp;
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
                String[] temp = after[2].split("\\.");
                int id = Integer.parseInt(after[1]);
                int nums = Integer.parseInt(temp[0]);
                String filePath = ConfigUtil.getFilePath(id);
                String url = filePath + fileName;
                File storeFile = new File(url);

                if (!storeFile.exists()) {
                    storeFile.mkdirs();
                }

                file.transferTo(new File(url));
                CameraMessage.addTotalNumsAndCount(id, nums);
                String webUrl = ConfigUtil.getPath(id) + fileName;
                int option = ConfigUtil.getCameraOption();
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
                String out = camera.getThreshold() + "_" + camera.getParam() + "_" + option;
                return out;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return "file is empty";
        }
        return "param error";
    }

    @RequestMapping(value = "/getHistory", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getHistory(@RequestParam(value = "id") int id, @RequestParam(value = "time") Long time) {
        Integer[] result = new Integer[1];
        double tempday = time.doubleValue();
        String day = Long.toString(Math.round(tempday / 1000 / 3600 / 24));
        switch (id) {
            case 1:
                result = personNumService.getHistory1(day);
                break;
            case 2:
                result = personNumService.getHistory2(day);
                break;
            case 3:
                result = personNumService.getHistory3(day);
                break;
            default:
                break;
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/openLisener", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void openLisener() {
        int MAX = 720;
        int count = 0;
        long preMin = 0;
        long nowMin;
        while (count < MAX) {
            long nowTime = System.currentTimeMillis();
            nowMin = nowTime / 1000 / 3600;
            if (nowMin != preMin) {
                int temp = CameraMessage.getCount1();
                int nums1 = CameraMessage.getTotalNums1() / ( temp == 0 ? temp + 1 : temp);
                temp = CameraMessage.getCount2();
                int nums2 = CameraMessage.getTotalNums2() / ( temp == 0 ? temp + 1 : temp);
                temp = CameraMessage.getCount3();
                int nums3 = CameraMessage.getTotalNums3() / ( temp == 0 ? temp + 1 : temp);
                Timestamp time = new Timestamp(nowTime);
                String day = Long.toString(nowMin / 24);
                CameraMessage.setCount1(0);
                CameraMessage.setTotalNums1(0);
                CameraMessage.setCount2(0);
                CameraMessage.setTotalNums2(0);
                CameraMessage.setCount3(0);
                CameraMessage.setTotalNums3(0);
                personNumService.addHistory1(day, time, nums1);
                personNumService.addHistory2(day, time, nums2);
                personNumService.addHistory3(day, time, nums3);
                preMin = nowTime;
                count++;
                try {
                    Thread.sleep(1000 * 60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
