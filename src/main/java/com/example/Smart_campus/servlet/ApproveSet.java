package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Approve;
import com.example.Smart_campus.dao.impl.ApproveDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
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
 * @date 2021/8/7 9:55 星期六
 */
@WebServlet(name = "setApprove", value = "/setApprove")
public class ApproveSet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);

        List<Approve> approves = new ApproveDaoImpl().queryApprove();
        String s = jsonObject.optString("schoolCard");
        for (Approve approve : approves) {
            if (s.equals(approve.getSchoolCard())){
                if ("贫困生申请".equals(approve.getTitle())){
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("alarm","重复提交");
                    resp.getWriter().write(jsonObject1.toString());
                    return;
                }
            }
        }

        int i = new ApproveDaoImpl().updateApproveDao(new Approve(
                jsonObject.optString("id"),
                jsonObject.optString("schoolCard"),
                jsonObject.optString("title"),
                jsonObject.optString("grade"),
                jsonObject.optString("majorId"),
                jsonObject.optString("time"),
                jsonObject.optString("state"),
                jsonObject.optString("clas"),
                jsonObject.optString("msg")
        ));

        System.out.println(jsonObject.toString());
        ServletUtils.isOk(jsonObject, i == 1);
        resp.getWriter().write(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
