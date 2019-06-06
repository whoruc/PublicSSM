package com.qiuligao.service;

import com.qiuligao.dao.PersonNumDao;
import com.qiuligao.entity.PersonNum;
import com.qiuligao.util.ConfigUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author l
 */
@Service("personNumService")
public class PersonNumServiceImpl implements PersonNumService {

    @Resource
    PersonNumDao personNumDao;

    public List<PersonNum> getAllNums() {
        List<PersonNum> list = personNumDao.getAllNums();
        list.get(0).setPicUrl(ConfigUtil.getLastNameC1());
        list.get(1).setPicUrl(ConfigUtil.getLastNameC2());
        list.get(2).setPicUrl(ConfigUtil.getLastNameC3());
        return list;
    }

    public void updateNumsById(int id, int num) {
        personNumDao.updateNumsById(id, num);
    }
}
