package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.Teacher;
import com.example.Smart_campus.dao.TeacherDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/2 15:17 星期一
 */
public class TeacherDaoImpl extends BaseDao implements TeacherDao {

    @Override
    public List<Teacher> queryTeacherList() {
        String sql = "select * from teacher";
        return queryForList(Teacher.class,sql);
    }

    @Override
    public Teacher querySchoolCard(String card) {
        String sql = "select * from teacher where schoolCard = ?";
        return queryForOne(Teacher.class,sql,card);
    }
}
