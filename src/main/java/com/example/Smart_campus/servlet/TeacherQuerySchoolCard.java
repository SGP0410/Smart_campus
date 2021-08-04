package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Teacher;
import com.example.Smart_campus.dao.impl.TeacherDaoImpl;
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
 * @date 2021/8/2 15:26 星期一
 */

@WebServlet(name = "GetTeacherQuerySchoolCard", value = "/GetTeacherQuerySchoolCard")
public class TeacherQuerySchoolCard extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        Teacher card = new TeacherDaoImpl().querySchoolCard(jsonObject.optString("card"));
        System.out.println(card);
        System.out.println("ss" + card.getSchoolCard());
        JSONObject jsonObject1 = new JSONObject(card);
        ServletUtils.isOk(jsonObject1, card != null);
        resp.getWriter().write(jsonObject1.toString());
    }
}
