package com.qiuligao.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author l
 */
public interface UserDao {

    /**
     * 登陆
     *
     * @param account
     * @param password
     * @return
     */
    int login(@Param("account") String account, @Param("password") String password);

    /**
     * 注册
     * @param account
     * @param password
     * @param phone
     * @return
     */
    int sign(@Param("account") String account, @Param("password") String password,
             @Param("phone") String phone);
}
