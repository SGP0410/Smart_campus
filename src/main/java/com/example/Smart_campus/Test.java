package com.example.Smart_campus;

import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.impl.StudentDaoImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> students =
                new StudentDaoImpl().queryStudentAll();
        System.out.println(students.size());
    }
}
