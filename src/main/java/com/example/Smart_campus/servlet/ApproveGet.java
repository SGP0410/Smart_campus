package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Approve;
import com.example.Smart_campus.dao.impl.ApproveDaoImpl;
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
 * @date 2021/8/7 10:37 星期六
 */


@WebServlet(name = "GetApprove", value = "/GetApprove")
public class ApproveGet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req,resp);
        List<Approve> approves = new ApproveDaoImpl().queryApprove();
        JSONObject jsonObject = new JSONObject();
        if (approves != null) {
            jsonObject.put("data", new JSONArray(approves));
        }
        ServletUtils.isOk(jsonObject, approves != null);
        resp.getWriter().write(jsonObject.toString());



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
