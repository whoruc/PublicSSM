package com.qiuligao.service;

/**
 * @author l
 */
public interface UserService {

    /**
     * 登陆
     * @param account
     * @param password
     * @return int
     */
    int login(String account, String password);

    /**
     * 注册
     * @param account
     * @param password
     * @return
     */
    int sign(String account, String password);
}
