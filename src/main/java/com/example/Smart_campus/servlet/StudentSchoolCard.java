package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.impl.StudentDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 关鑫
 * @date 2021/8/4 15:49 星期三
 */
@WebServlet(name = "GetStudentSchoolCard", value = "/GetStudentSchoolCard")
public class StudentSchoolCard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        Student student = new StudentDaoImpl().queryStudentSchoolCard(jsonObject.optString("card"));
        JSONObject jsonObject1 = new JSONObject();
        if (student != null) {
            jsonObject1 = new JSONObject(student);
        }
        ServletUtils.isOk(jsonObject1, student != null);
        resp.getWriter().write(jsonObject1.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
