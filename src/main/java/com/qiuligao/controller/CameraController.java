package com.qiuligao.controller;

import com.alibaba.fastjson.JSON;
import com.qiuligao.entity.Camera;
import com.qiuligao.service.CameraService;
import com.qiuligao.util.ConfigUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
        List<Camera> cameras = cameraService.getAllCamera();
        ConfigUtil.setThreshold1(cameras.get(0).getThreshold());
        ConfigUtil.setThreshold2(cameras.get(1).getThreshold());
        ConfigUtil.setThreshold3(cameras.get(2).getThreshold());
        return JSON.toJSONString(cameras);
    }

    @RequestMapping(value = "/modifyThreshold", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String modifyThreshold(@RequestParam (value = "id") int id, @RequestParam (value = "threshold") int threshold) {
        cameraService.modifyThreshold(id, threshold);
        switch (id) {
            case 1:
                ConfigUtil.setThreshold1(threshold);
                break;
            case 2:
                ConfigUtil.setThreshold2(threshold);
                break;
            case 3:
                ConfigUtil.setThreshold3(threshold);
                break;
            default:
                break;
        }
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

    @RequestMapping(value = "/modifyOption", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String modifyOption(@RequestParam(value = "option") int option) {
        cameraService.modifyOption(option);
        return "1";
    }

    @RequestMapping(value = "/getCameraOption", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getCameraOption() {
        return JSON.toJSONString(cameraService.getCameraOption());
    }

    @RequestMapping(value = "/modifyParam", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String modifyParam(@RequestParam(value = "id") int id, @RequestParam(value = "param") int param) {
        cameraService.modifyParam(id, param);
        return "1";
    }
}
