package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.College;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/7 15:14 星期一
 */

public interface CollegeDao {


    /**
     * 查询所有系
     * @return
     */
    public List<College> queryCollegeAll();

}
