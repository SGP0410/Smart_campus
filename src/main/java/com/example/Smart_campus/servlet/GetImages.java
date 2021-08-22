package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Image;
import com.example.Smart_campus.dao.impl.ImageDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetImages", value = "/GetImages")
public class GetImages extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.Setting(request, response);

        ImageDaoImpl imageDao = new ImageDaoImpl();
        List<Image> imageList = imageDao.queryImageAll();
        JSONObject jsonObject1 = new JSONObject();
        if (imageList != null) {
            for (Image image : imageList) {
                String imageUrl = ServletUtils.getImageUrl(request, image.getName());
                image.setName(imageUrl);
            }
            jsonObject1.put("rows", new JSONArray(new Gson().toJson(imageList)));
        }

        ServletUtils.isOk(jsonObject1, imageList != null);

        response.getWriter().write(jsonObject1.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
