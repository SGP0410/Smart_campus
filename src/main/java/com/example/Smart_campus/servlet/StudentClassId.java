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
 * @date 2021/8/10 10:25 星期二
 */
@WebServlet(name = "GetStudentClassId", value = "/GetStudentClassId")
public class StudentClassId extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        List<Student> classid = new StudentDaoImpl().queryClassId(jsonObject.optString("classid"));
        JSONObject jsonObject1 = new JSONObject();
        if (classid != null) {
            jsonObject1.put("total",classid.size());
            jsonObject1.put("data", new JSONArray(classid));
        }

        ServletUtils.isOk(jsonObject1, classid != null);
        resp.getWriter().write(jsonObject1.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
