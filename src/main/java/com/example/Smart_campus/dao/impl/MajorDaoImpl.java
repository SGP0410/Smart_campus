package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.Major;
import com.example.Smart_campus.dao.MajorDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/7 16:03 星期一
 */
public class MajorDaoImpl extends BaseDao implements MajorDao {

    /**
     * 通过所在系的id查询专业
     * @param collegeId 所在系的id
     * @return
     */
    @Override
    public List<Major> queryMajorByCollegeId(String collegeId) {
        String sql = ("select * from major where collegeId = ?");
        return queryForList(Major.class,sql,collegeId);
    }

    /**
     * 查询所有专业
     * @return
     */
    @Override
    public List<Major> queryMajorAll() {
        String sql = ("select * from major");
        return queryForList(Major.class,sql);
    }

}
