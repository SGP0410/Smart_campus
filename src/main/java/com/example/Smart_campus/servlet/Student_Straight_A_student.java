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
 * @date 2021/6/18 10:26 星期五
 */

@WebServlet(name = "getStraightAStudent",value = "/getStraightAStudent")
public class Student_Straight_A_student extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req,resp);
        List<Student> studentList = new StudentDaoImpl().queryStudentAll();
        JSONObject jsonObject = new JSONObject();
        for (Student student : studentList) {
            student.setSum(Integer.parseInt(student.getYu())+Integer.parseInt(student.getShu())+Integer.parseInt(student.getWai())+"");
        }
        if (studentList != null){
            jsonObject.put("data",new JSONArray(studentList));
        }
        ServletUtils.isOk(jsonObject,true);
        resp.getWriter().write(jsonObject.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }



}
