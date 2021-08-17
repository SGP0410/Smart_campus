package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.ClassSchedule;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/9 16:24 星期一
 */
public interface ClassScheduleDao {

    public List<ClassSchedule> queryClassSchedule(String schoolCard);

}
