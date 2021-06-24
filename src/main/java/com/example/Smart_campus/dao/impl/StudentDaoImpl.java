package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.StudentDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/8 15:37 星期二
 */

public class StudentDaoImpl extends BaseDao implements StudentDao {


    /**
     * 查询学生表的所有内容
     *
     * @return
     */
    @Override
    public List<Student> queryStudentAll() {
        String sql = "select * from student";
        return queryForList(Student.class, sql);
    }

    @Override
    public List<Student> queryStudentByMunicipalId(String municipalId) {
        String sql = "select * from student where municipalId = ?";
        return queryForList(Student.class, sql, municipalId);
    }

    @Override
    public List<Student> queryStudentByMajorId(String majorId) {
        String sql = "select * from student where majorId = ?";
        return queryForList(Student.class, sql, majorId);
    }
}
