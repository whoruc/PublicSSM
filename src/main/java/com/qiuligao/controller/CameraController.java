package com.qiuligao.controller;

import com.alibaba.fastjson.JSON;
import com.qiuligao.entity.Camera;
import com.qiuligao.service.CameraService;
import com.qiuligao.util.ConfigUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author l
 */
@Controller
@RequestMapping("")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CameraController {

    @Resource
    private CameraService cameraService;

    /**
     * 通过id返回camera信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getCamera", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findCameraById(@RequestParam (value = "id") int id) {
        Camera camera = cameraService.findCameraById(id);
        System.out.println(JSON.toJSONString(camera));
        return JSON.toJSONString(camera);
    }

    @RequestMapping(value = "/getAllCamera", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllCamera() {
        return JSON.toJSONString(cameraService.getAllCamera());
    }

    @RequestMapping(value = "/modifyThreshold", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String modifyThreshold(@RequestParam (value = "id") int id, @RequestParam (value = "threshold") int threshold) {
        cameraService.modifyThreshold(id, threshold);
        return JSON.toJSONString(1);
    }

    @RequestMapping(value = "/getAllPic", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllPic() {
        return JSON.toJSONString(ConfigUtil.getLastNameC1());
    }

    @RequestMapping(value = "/getNearestGuard", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getNearestGuard(@RequestParam (value = "id") int id) {
        return JSON.toJSONString(cameraService.getNearestGuard(id));
    }

    @RequestMapping(value = "/getAllGuards", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllGuards() {
        return JSON.toJSONString(cameraService.getAllGuards());
    }

    @RequestMapping(value = "/addExcreedTimes", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addExreedTimes(@RequestParam (value = "id") int id) {
        cameraService.addExcreedTimes(id);
        return "1";
    }
}
