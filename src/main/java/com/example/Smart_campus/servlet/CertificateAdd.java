package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Certificate;
import com.example.Smart_campus.dao.impl.CertificateDaoImpl;
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
 * @date 2021/8/12 15:50 星期四
 * @Description com.example.Smart_campus.servlet
 */
@WebServlet(name = "SetCertificateAdd", value = "/SetCertificateAdd")
public class CertificateAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        int i = new CertificateDaoImpl().addCertificate(new Certificate(jsonObject.optString("id"),
                jsonObject.optString("title"),
                jsonObject.optString("level"),
                jsonObject.optString("time"),
                jsonObject.optString("member"),
                jsonObject.optString("grade"),
                jsonObject.optString("teacher"),
                jsonObject.optString("years"),
                jsonObject.optString("name"),
                jsonObject.optString("schoolcard"),
                jsonObject.optString("state"),
                jsonObject.optString("classid")));

        ServletUtils.isOk(jsonObject, i == 1);
        resp.getWriter().write(jsonObject.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
