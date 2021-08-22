package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Bulletin;
import com.example.Smart_campus.dao.impl.BulletinDaoImpl;
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
 * @date 2021/8/19 16:50 星期四
 * @Description com.example.Smart_campus.servlet
 */
@WebServlet(name = "GetBulletin",value = "/GetBulletin")
public class BulletinGet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        List<Bulletin> bulletins = new BulletinDaoImpl().queryBulletin();
        JSONObject jsonObject = new JSONObject();
        if (bulletins != null) {
            jsonObject.put("data", new JSONArray(bulletins));
        }
        ServletUtils.isOk(jsonObject, bulletins != null);
        resp.getWriter().write(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
