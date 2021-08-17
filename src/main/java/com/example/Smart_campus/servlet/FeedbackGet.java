package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Feedback;
import com.example.Smart_campus.dao.impl.FeedbackDaoImpl;
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
 * @date 2021/8/9 10:19 星期一
 */

@WebServlet(name = "GetFeedback", value = "/GetFeedback")
public class FeedbackGet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        List<Feedback> feedbacks = new FeedbackDaoImpl().queryFeedback();
        JSONObject jsonObject = new JSONObject();
        if (feedbacks != null) {
            jsonObject.put("data", new JSONArray(feedbacks));
        }
        ServletUtils.isOk(jsonObject, feedbacks != null);
        resp.getWriter().write(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
