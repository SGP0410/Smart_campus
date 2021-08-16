package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Certificate;
import com.example.Smart_campus.dao.impl.CertificateDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/12 15:31 星期四
 * @Description com.example.Smart_campus.servlet
 */

@WebServlet(name = "GetCertificate", value = "/GetCertificate")
public class CertificateGetQuery extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req, resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        List<Certificate> schoolcard = new CertificateDaoImpl().querySchoolCard(jsonObject.optString("schoolcard"));
        JSONObject jsonObject1 = new JSONObject();
        if (schoolcard != null) {
            jsonObject1.put("data",new JSONArray(schoolcard));
        }
        ServletUtils.isOk(jsonObject1, schoolcard != null);
        resp.getWriter().write(jsonObject1.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
