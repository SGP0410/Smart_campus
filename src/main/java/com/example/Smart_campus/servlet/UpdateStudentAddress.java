package com.example.Smart_campus.servlet;

import com.example.Smart_campus.dao.impl.StudentDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateStudentAddress", value = "/UpdateStudentAddress")
public class UpdateStudentAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.Setting(request, response);
        JSONObject jsonObject = ServletUtils.getJSONObject(request);

        int i = new StudentDaoImpl().updateStudentAddress(jsonObject.optString("address"), jsonObject.optString("id"));

        JSONObject jsonObject1 = new JSONObject();

        ServletUtils.isOk(jsonObject1 , i == 1);

        response.getWriter().write(jsonObject1.toString());
    }
}
