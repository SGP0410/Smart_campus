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
 * @date 2021/6/7 17:11 星期一
 */

/**
 *查询所有市
 */
@WebServlet(name = "getMunicipal_query_all",value = "/getMunicipal_query_all")
public class Municipal_query_all extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req,resp);
        List<Municipal> municipal_s = new MunicipalDaoImpl().queryMunicipalAll();
        JSONObject jsonObject = new JSONObject();
        if (municipal_s != null){
            jsonObject.put("data",new JSONArray(municipal_s));
        }
        ServletUtils.isOk(jsonObject, municipal_s != null);
        resp.getWriter().write(jsonObject.toString());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
