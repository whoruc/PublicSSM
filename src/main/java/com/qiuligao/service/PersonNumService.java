package com.qiuligao.service;

import com.qiuligao.entity.PersonNum;

import java.util.List;

public interface PersonNumService {

    /**
     * 返回所有地点的人数
     * @return
     */
    List<PersonNum> getAllNums();

    /**
     * 根据相机ID更新人数
     * @param id
     */
    void updateNumsById(int id, int num);
}
