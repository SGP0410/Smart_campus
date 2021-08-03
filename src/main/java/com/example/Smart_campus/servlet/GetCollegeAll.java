package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.College;
import com.example.Smart_campus.dao.impl.CollegeDaoImpl;
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
 * @date 2021/6/7 15:20 星期一
 */

/**
 * 查询学校所有系
 */
@WebServlet(name = "GetCollegeAll",value = "/GetCollegeAll")
public class GetCollegeAll extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req,resp);
        List<College> college = new CollegeDaoImpl().queryCollegeAll();
        JSONObject jsonObject = new JSONObject();
        if (college != null) {
            jsonObject.put("data",new JSONArray(college));
        }

        ServletUtils.isOk(jsonObject , college != null);
        resp.getWriter().write(jsonObject.toString());
    }

}
