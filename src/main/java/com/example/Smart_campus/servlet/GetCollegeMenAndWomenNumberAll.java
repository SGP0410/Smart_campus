package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.College;
import com.example.Smart_campus.bean.Major;
import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.impl.CollegeDaoImpl;
import com.example.Smart_campus.dao.impl.MajorDaoImpl;
import com.example.Smart_campus.dao.impl.StudentDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetCollegeMenAndWomenNumberAll", value = "/GetCollegeMenAndWomenNumberAll")
public class GetCollegeMenAndWomenNumberAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ServletUtils.Setting(request, response);

        List<College> collegeList =
            new CollegeDaoImpl().queryCollegeAll();

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (College college : collegeList) {

            List<Major> majorList = new MajorDaoImpl()
                .queryMajorByCollegeId(college.getCollegeId());

            List<Student> studentList = new ArrayList<>();

            StudentDaoImpl studentDao = new StudentDaoImpl();
            for (Major major : majorList) {
                studentList.addAll(studentDao.queryStudentByMajorId(major.getId()));
            }

            int man = 0;
            int woman = 0;

            for (Student student : studentList) {
                if (student.getSex().equals("男")) {
                    man++;
                } else if (student.getSex().equals("女")) {
                    woman++;
                }
            }

            JSONObject jsonObject1 = new JSONObject(new Gson().toJson(college));
            jsonObject1.put("man", man);
            jsonObject1.put("woman", woman);
            jsonArray.put(jsonObject1);
        }

        ServletUtils.isOk(jsonObject, jsonArray.length() > 0);
        jsonObject.put("rows", jsonArray);

        response.getWriter().write(jsonObject.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}
