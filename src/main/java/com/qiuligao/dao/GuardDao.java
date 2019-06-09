package com.qiuligao.dao;

import com.qiuligao.entity.Guard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author l
 */
public interface GuardDao {

    /**
     * 由摄像头ID得到最近的保安
     * @param longitude
     * @param latitude
     * @return
     */
    List<Guard> getNearestGuard(@Param(value = "longitude") double longitude,
                                @Param(value = "latitude") double latitude);

    /**
     * 获取所有保安的信息
     * @return
     */
    List<Guard> getAllGuards();
}
