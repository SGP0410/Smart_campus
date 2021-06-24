package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Municipal;
import com.example.Smart_campus.bean.Province;
import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.impl.MajorDaoImpl;
import com.example.Smart_campus.dao.impl.MunicipalDaoImpl;
import com.example.Smart_campus.dao.impl.ProvinceDaoImpl;
import com.example.Smart_campus.dao.impl.StudentDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "GetMunicipalStudentSourceByProvinceName", value = "/GetMunicipalStudentSourceByProvinceName")
public class GetMunicipalStudentSourceByProvinceName extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        ServletUtils.Setting(request, response);

        JSONObject jsonObject = ServletUtils.getJSONObject(request);

        MunicipalDaoImpl municipalDao = new MunicipalDaoImpl();
        ProvinceDaoImpl provinceDao = new ProvinceDaoImpl();

        Province province = provinceDao
            .queryProvinceByProvinceName(jsonObject.optString("provinceName"));

        List<Municipal> municipalList = municipalDao
            .queryMunicipalByProvinceId(province.getProvinceId());

        JSONObject jsonObject1 = new JSONObject(new Gson().toJson(province));
        JSONArray jsonArray = new JSONArray();
        System.out.println("municipalList::"+municipalList.size());
        for (Municipal municipal : municipalList) {
            JSONObject jsonObject2 = new JSONObject(new Gson().toJson(municipal));
            List<Student> studentList =
                new StudentDaoImpl().queryStudentByMunicipalId(municipal.getId());

            int eliteStudent = 0;
            int poorStudent = 0;

            for (Student student : studentList) {
                if (Integer.parseInt(student.getYu()) + Integer.parseInt(student.getShu()) +
                    Integer.parseInt(student.getWai()) > 200){
                    eliteStudent ++;
                }
                if (student.getPovertyStudent().equals("1")){
                    poorStudent ++;
                }
            }
            jsonObject2.put("eliteStudent" , eliteStudent);
            jsonObject2.put("poorStudent" , poorStudent);
            jsonArray.put(jsonObject2);
        }

        ServletUtils.isOk(jsonObject1 , jsonArray.length() > 0);
        jsonObject1.put("rows" , jsonArray);
        response.getWriter().write(jsonObject1.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}
