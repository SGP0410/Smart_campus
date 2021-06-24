package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.impl.StudentDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/8 15:38 星期二
 */

/**
 * 查询学生表的所有内容
 */
@WebServlet(name = "getStudent_query_all",value = "/getStudent_query_all")
public class Student_query_all extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req,resp);
        List<Student> student_query_alls = new StudentDaoImpl().queryStudentAll();
        JSONObject jsonObject = new JSONObject();
        if (student_query_alls != null){
            jsonObject.put("data",new JSONArray(student_query_alls));
        }
        ServletUtils.isOk(jsonObject,student_query_alls != null);
        resp.getWriter().write(jsonObject.toString());
    }
}
