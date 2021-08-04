package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.Teacher;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/2 15:17 星期一
 */
public interface TeacherDao {

    public List<Teacher> queryTeacherList();

    public Teacher querySchoolCard(String card);

}
