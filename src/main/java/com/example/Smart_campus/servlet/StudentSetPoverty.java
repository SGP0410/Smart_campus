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
 * @date 2021/8/11 14:42 星期三
 */
@WebServlet(name = "SetStudentPoverty",value = "/SetStudentPoverty")
public class StudentSetPoverty extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        int i = new StudentDaoImpl().updateStudentPoverty(
                jsonObject.optString("poverty"),
                jsonObject.optString("schoolCard"));

        ServletUtils.isOk(jsonObject, i == 1);
        System.out.println(jsonObject.toString());
        resp.getWriter().write(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
