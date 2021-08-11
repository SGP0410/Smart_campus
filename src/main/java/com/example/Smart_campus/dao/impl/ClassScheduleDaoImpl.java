package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.ClassSchedule;
import com.example.Smart_campus.dao.ClassScheduleDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/9 16:26 星期一
 */
public class ClassScheduleDaoImpl extends BaseDao implements ClassScheduleDao {

    @Override
    public List<ClassSchedule> queryClassSchedule(String classid) {
        String sql = "select * from classschedule where classid = ?";
        return queryForList(ClassSchedule.class,sql,classid);
    }


}
