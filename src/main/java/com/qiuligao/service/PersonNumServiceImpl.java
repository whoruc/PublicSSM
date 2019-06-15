package com.qiuligao.service;

import com.qiuligao.dao.PersonNumDao;
import com.qiuligao.entity.PersonNum;
import com.qiuligao.util.ConfigUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author l
 */
@Service("personNumService")
public class PersonNumServiceImpl implements PersonNumService {

    @Resource
    CameraService cameraService;

    @Resource
    PersonNumDao personNumDao;

    public List<PersonNum> getAllNums() {
        List<PersonNum> list = personNumDao.getAllNums();
        list.get(0).setPicUrl(ConfigUtil.getLastNameC1());
        list.get(0).setThreshold(ConfigUtil.getThreshold1());
        list.get(1).setThreshold(ConfigUtil.getThreshold2());
        list.get(1).setPicUrl(ConfigUtil.getLastNameC2());
        list.get(2).setThreshold(ConfigUtil.getThreshold3());
        list.get(2).setPicUrl(ConfigUtil.getLastNameC3());
        return list;
    }

    public void updateNumsById(int id, int num) {
        personNumDao.updateNumsById(id, num);
    }

    public Integer[] getHistory1(String day) {
        Integer[] out = personNumDao.getHistory1(day);
        return out;
    }

    public Integer[] getHistory2(String day) {
        Integer[] out = personNumDao.getHistory2(day);
        return out;
    }

    public Integer[] getHistory3(String day) {
        Integer[] out = personNumDao.getHistory3(day);
        return out;
    }

    public void addHistory1(String day, Timestamp time, int num) {
        personNumDao.addHistory1(day, time, num);
    }

    public void addHistory2(String day, Timestamp time, int num) {
        personNumDao.addHistory2(day, time, num);
    }

    public void addHistory3(String day, Timestamp time, int num) {
        personNumDao.addHistory3(day, time, num);
    }
}
