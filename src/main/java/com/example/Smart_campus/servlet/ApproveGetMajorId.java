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
 * @date 2021/8/11 9:02 星期三
 */
@WebServlet(name = "GetApproveMajorId", value = "/GetApproveMajorId")
public class ApproveGetMajorId extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        List<Approve> majorId = new ApproveDaoImpl().queryMajorId(jsonObject.optString("majorId"));
        JSONObject jsonObject1 = new JSONObject();
        if (majorId != null) {
            jsonObject1.put("data", new JSONArray(majorId));
        }
        ServletUtils.isOk(jsonObject1, majorId != null);
        resp.getWriter().write(jsonObject1.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
