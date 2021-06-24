package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Municipal;
import com.example.Smart_campus.dao.impl.MunicipalDaoImpl;
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
 * @date 2021/6/7 16:51 星期一
 */

/**
 * 通过省级id查询市
 */
@WebServlet(name = "getMunicipal_query_provinceId",value = "/getMunicipal_query_provinceId")
public class Municipal_query_provinceId extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req,resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        List<Municipal> municipal_s = new MunicipalDaoImpl().queryMunicipalByProvinceId(jsonObject.optString("provinceId"));
        JSONObject jsonObject1 = new JSONObject();
        System.out.println(municipal_s.size());
        if (municipal_s != null){
            jsonObject1.put("data",new JSONArray(municipal_s));
        }
        ServletUtils.isOk(jsonObject1, municipal_s != null);
        resp.getWriter().write(jsonObject1.toString());
    }
}
