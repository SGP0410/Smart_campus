package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.WorkNature;
import com.example.Smart_campus.dao.impl.WorkNatureDaoImpl;
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
 * @date 2021/6/7 17:20 星期一
 */

/**
 * 查询所有就业信息
 */
@WebServlet(name = "getWorkNatureName_query_all",value = "/getWorkNatureName_query_all")
public class getWorkNatureName_query_all extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req,resp);
        List<WorkNature> work_natures = new WorkNatureDaoImpl().queryWorkNatureAll();
        JSONObject jsonObject = new JSONObject();

        if (work_natures != null){
            jsonObject.put("data",new JSONArray(work_natures));
        }
        ServletUtils.isOk(jsonObject, work_natures != null);
        resp.getWriter().write(jsonObject.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
