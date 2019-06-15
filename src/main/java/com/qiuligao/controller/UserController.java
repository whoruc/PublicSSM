package com.qiuligao.controller;

import com.alibaba.fastjson.JSON;
import com.qiuligao.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author l
 */
@Controller
@RequestMapping("")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登陆
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String loginUser(@RequestParam(value = "account")String account,
                           @RequestParam(value = "password") String password) {

        int status = userService.login(account, password);
        System.out.println(JSON.toJSONString(status));
        return JSON.toJSONString(status);
    }

    /**
     * 注册
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/sign", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String signUser(@RequestParam(value = "account") String account,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "phone") String phone) {
        int status = userService.sign(account, password, phone);
        System.out.println(JSON.toJSONString(status));
        return JSON.toJSONString(status);
    }
}
