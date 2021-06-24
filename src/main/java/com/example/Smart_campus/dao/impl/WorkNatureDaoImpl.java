package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.WorkNature;
import com.example.Smart_campus.dao.WorkNatureDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/7 17:23 星期一
 */

public class WorkNatureDaoImpl extends BaseDao implements WorkNatureDao {

    /**
     * 从查询就业类型
     * @return
     */
    @Override
    public List<WorkNature> queryWorkNatureAll() {
        String sql = "select * from work_nature";
        return queryForList(WorkNature.class,sql);
    }
}
