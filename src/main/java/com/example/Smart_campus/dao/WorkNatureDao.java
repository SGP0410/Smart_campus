package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.WorkNature;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/7 17:24 星期一
 */

public interface WorkNatureDao {

    /**
     * 查询就业类型
     * @return
     */
    public List<WorkNature> queryWorkNatureAll();

}
