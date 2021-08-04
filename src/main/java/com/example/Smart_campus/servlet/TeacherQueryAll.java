package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Teacher;
import com.example.Smart_campus.dao.impl.TeacherDaoImpl;
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
 * @date 2021/8/2 15:16 星期一
 */

@WebServlet(name = "GetTeacherQueryAll", value = "/GetTeacherQueryAll")
public class TeacherQueryAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        List<Teacher> teachers = new TeacherDaoImpl().queryTeacherList();
        JSONObject jsonObject = new JSONObject();
        if (teachers != null) {
            jsonObject.put("data", new JSONArray(teachers));
        }
        ServletUtils.isOk(jsonObject, teachers != null);
        resp.getWriter().write(jsonObject.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
