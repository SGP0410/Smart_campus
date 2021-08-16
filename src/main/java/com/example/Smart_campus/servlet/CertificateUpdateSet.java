package com.example.Smart_campus.servlet;

import com.example.Smart_campus.dao.impl.CertificateDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import org.json.JSONObject;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 关鑫
 * @date 2021/8/16 9:08 星期一
 * @Description com.example.Smart_campus.servlet
 */

@WebServlet(name = "SetCertificateUpdate", value = "/SetCertificateUpdate")
public class CertificateUpdateSet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        int i = new CertificateDaoImpl().updateCertificate(jsonObject.optString("state"), jsonObject.optString("id"));
        ServletUtils.isOk(jsonObject, i == 1);
        resp.getWriter().write(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
