package com.example.Smart_campus.servlet;

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
 * @date 2021/8/10 15:55 星期二
 */
@WebServlet(name = "SetStudentUpdateId",value = "/SetStudentUpdateId")
public class StudentUpdateId extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        int i = new StudentDaoImpl().updateStudent(
                jsonObject.optString("id"),
                jsonObject.optString("yu"),
                jsonObject.optString("shu"),
                jsonObject.optString("wai"));
        System.out.println(jsonObject.toString());
        ServletUtils.isOk(jsonObject, i == 1);
        resp.getWriter().write(jsonObject.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
