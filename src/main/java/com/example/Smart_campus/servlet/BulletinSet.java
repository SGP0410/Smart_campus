package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Bulletin;
import com.example.Smart_campus.dao.impl.BulletinDaoImpl;
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
 * @date 2021/8/19 17:04 星期四
 * @Description com.example.Smart_campus.servlet
 */
@WebServlet(name = "SetBulletin",value = "/SetBulletin")
public class BulletinSet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req,resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        int i = new BulletinDaoImpl().addBulletin(new Bulletin(jsonObject.optString("id"),
                jsonObject.optString("title"),
                jsonObject.optString("msg"),
                jsonObject.optString("time"),
                jsonObject.optString("faculty")
        ));
        ServletUtils.isOk(jsonObject,i==1);
        resp.getWriter().write(jsonObject.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
