package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.TradingSite;
import com.example.Smart_campus.dao.impl.TradingSiteDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetTradingSiteById", value = "/GetTradingSiteById")
public class GetTradingSiteById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.Setting(request, response);
        JSONObject jsonObject = ServletUtils.getJSONObject(request);

        TradingSite tradingSite = new TradingSiteDaoImpl().queryTradingSiteById(jsonObject.optString("tradingSiteId"));

        JSONObject jsonObject1 = new JSONObject();

        ServletUtils.isOk(jsonObject1 , tradingSite != null);

        response.getWriter().write(jsonObject1.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
