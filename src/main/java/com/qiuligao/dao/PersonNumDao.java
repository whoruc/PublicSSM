package com.qiuligao.dao;

import com.qiuligao.entity.PersonNum;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author l
 */
public interface PersonNumDao {
    /**
     * 返回所有地点的人数
     * @return
     */
    List<PersonNum> getAllNums();

    /**
     * 根据相机ID更新人数
     * @param id
     * @param num
     */
    void updateNumsById(@Param(value = "id") int id, @Param(value = "num") int num);

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
    void addHistory1(@Param("day") String day, @Param("time")Timestamp time, @Param("nums") int num);

    /**
     * 添加每分钟的人数到对应的表中
     * @param day
     * @param time
     * @param num
     */
    void addHistory2(@Param("day") String day, @Param("time")Timestamp time, @Param("nums") int num);

    /**
     * 添加每分钟的人数到对应的表中
     * @param day
     * @param time
     * @param num
     */
    void addHistory3(@Param("day") String day, @Param("time")Timestamp time, @Param("nums") int num);
}
