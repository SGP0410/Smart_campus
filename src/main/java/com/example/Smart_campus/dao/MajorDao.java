package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.Major;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/7 16:04 星期一
 */

public interface MajorDao {

    /**
     * 通过所在系查询专业
     * @param collegeId 所在系的id
     * @return
     */
    public List<Major> queryMajorByCollegeId(String collegeId);

    /**
     * 查询所有专业
     * @return 查询所有专业
     */
    public List<Major> queryMajorAll();

}
