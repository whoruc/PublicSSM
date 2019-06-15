package com.qiuligao.service;

import com.qiuligao.entity.PersonNum;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
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

    /**
     * 获取摄像头1的历史记录
     * @param day
     * @return
     */
    Integer[] getHistory1(String day);

    /**
     * 获取摄像头2的历史记录
     * @param day
     * @return
     */
    Integer[] getHistory2(String day);

    /**
     * 获取摄像头3的历史记录
     * @param day
     * @return
     */
    Integer[] getHistory3(String day);

    /**
     * 添加每分钟的人数到对应的表中
     * @param day
     * @param time
     * @param num
     */
    void addHistory1(String day, Timestamp time, int num);

    /**
     * 添加每分钟的人数到对应的表中
     * @param day
     * @param time
     * @param num
     */
    void addHistory2(String day, Timestamp time, int num);

    /**
     * 添加每分钟的人数到对应的表中
     * @param day
     * @param time
     * @param num
     */
    void addHistory3(@Param("day") String day, @Param("time")Timestamp time, @Param("nums") int num);
}
