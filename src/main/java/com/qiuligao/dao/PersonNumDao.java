package com.qiuligao.dao;

import com.qiuligao.entity.PersonNum;
import org.apache.ibatis.annotations.Param;

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
}
