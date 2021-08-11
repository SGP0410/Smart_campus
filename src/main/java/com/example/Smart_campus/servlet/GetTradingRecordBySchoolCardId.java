package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.TradingRecord;
import com.example.Smart_campus.dao.impl.TradingRecordDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetTradingRecordBySchoolCardId", value = "/GetTradingRecordBySchoolCardId")
public class GetTradingRecordBySchoolCardId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.Setting(request, response);
        JSONObject jsonObject = ServletUtils.getJSONObject(request);

        List<TradingRecord> tradingRecordList = new TradingRecordDaoImpl()
                .queryTradingRecordBySchoolCardId(jsonObject.optString("schoolCardId"));

        JSONObject jsonObject1 = new JSONObject();

        if (tradingRecordList != null){
            JSONArray jsonArray = new JSONArray(new Gson().toJson(tradingRecordList));
            jsonObject1.put("rows" , jsonArray);
        }

        ServletUtils.isOk(jsonObject1 , tradingRecordList != null);

        response.getWriter().write(jsonObject1.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
