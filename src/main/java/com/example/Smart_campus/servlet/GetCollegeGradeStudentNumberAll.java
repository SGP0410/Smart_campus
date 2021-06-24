package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.College;
import com.example.Smart_campus.bean.Major;
import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.impl.CollegeDaoImpl;
import com.example.Smart_campus.dao.impl.MajorDaoImpl;
import com.example.Smart_campus.dao.impl.StudentDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "GetCollegeGradeStudentNumberAll", value = "/GetCollegeGradeStudentNumberAll")
public class GetCollegeGradeStudentNumberAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ServletUtils.Setting(request, response);

        List<College> collegeList = new CollegeDaoImpl().queryCollegeAll();

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        MajorDaoImpl majorDao = new MajorDaoImpl();
        StudentDaoImpl studentDao = new StudentDaoImpl();

        for (College college : collegeList) {//学院（系）
            List<Major> majorList = //专业
                majorDao.queryMajorByCollegeId(college.getCollegeId());
            List<Student> studentList = new ArrayList<>();
            for (Major major : majorList) {
                studentList.addAll(studentDao.queryStudentByMajorId(major.getId()));
            }

            Map<String , List<Student>> studentMap = new HashMap<>();
            List<Student> students;
            for (Student student : studentList) {
                if (studentMap.get(student.getGrade()) == null){
                    students = new ArrayList<>();
                }else {
                    students = studentMap.get(student.getGrade());
                }
                students.add(student);
                studentMap.put(student.getGrade() , students);
            }

            JSONObject jsonObject1 = new JSONObject(new Gson().toJson(college));
            JSONArray jsonArray1 = new JSONArray();
            List<String> keys = new ArrayList<>(studentMap.keySet());
            for (String key : keys) {
                JSONObject jsonObject2 = new JSONObject();
                jsonObject2.put("grade" , key);
                jsonObject2.put("number" , studentMap.get(key).size());
                jsonArray1.put(jsonObject2);
            }
            jsonObject1.put("rows" , jsonArray1);
            jsonArray.put(jsonObject1);
        }
        ServletUtils.isOk(jsonObject , jsonArray.length() > 0);
        jsonObject.put("rows" , jsonArray);

        response.getWriter().write(jsonObject.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {



    }
}
