package com.qiuligao.service;

import com.qiuligao.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author l
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public int login(String account, String password) {
        return userDao.login(account, password);
    }

    public int sign(String account, String password) {
        int status = login(account, password);
        if(status == 1 || status == -1) {
            return 0;
        }
        userDao.sign(account, password);
        return 1;
    }
}
