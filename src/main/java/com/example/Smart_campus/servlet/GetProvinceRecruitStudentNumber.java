package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Municipal;
import com.example.Smart_campus.bean.Province;
import com.example.Smart_campus.dao.impl.MunicipalDaoImpl;
import com.example.Smart_campus.dao.impl.ProvinceDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "GetProvinceRecruitStudentNumber", value = "/GetProvinceRecruitStudentNumber")
public class GetProvinceRecruitStudentNumber extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        ServletUtils.Setting(request, response);

        List<Province> provinceList = new ProvinceDaoImpl().queryProvinceAll();

        MunicipalDaoImpl municipalDao = new MunicipalDaoImpl();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Province province : provinceList) {
            JSONObject jsonObject1 = new JSONObject(new Gson().toJson(province));
            List<Municipal> municipalList = municipalDao
                .queryMunicipalByProvinceId(province.getProvinceId());
            int enrollStudentNum = 0;//普通
            int overseasStudentNum = 0;//留学
            for (Municipal municipal : municipalList) {
                enrollStudentNum += Integer.parseInt(municipal.getEnrollStudentNum());
                overseasStudentNum += Integer.parseInt(municipal.getOverseasStudentNum());
            }
            jsonObject1.put("enrollStudentNum" , enrollStudentNum);
            jsonObject1.put("overseasStudentNum" , overseasStudentNum);

            jsonArray.put(jsonObject1);
        }

        ServletUtils.isOk(jsonObject , jsonArray.length() > 0);

        jsonObject.put("rows" , jsonArray);

        response.getWriter().write(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}
