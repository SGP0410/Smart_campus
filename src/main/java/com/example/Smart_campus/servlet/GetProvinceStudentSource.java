package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Municipal;
import com.example.Smart_campus.bean.Province;
import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.impl.MunicipalDaoImpl;
import com.example.Smart_campus.dao.impl.ProvinceDaoImpl;
import com.example.Smart_campus.dao.impl.StudentDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetProvinceStudentSource", value = "/GetProvinceStudentSource")
public class GetProvinceStudentSource extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.Setting(request, response);

        Province province = new ProvinceDaoImpl()
                .queryProvinceByProvinceName(request.getParameter("provinceName"));

        if (province == null){
            System.out.println("省名称参数不对");
            return;
        }

        List<Municipal> municipalList =
                new MunicipalDaoImpl().queryMunicipalByProvinceId(province.getProvinceId());

        JSONObject jsonObject = new JSONObject(new Gson().toJson(province));

        int eliteStudent = 0;
        int poorStudent = 0;
        int x = 0;

        for (Municipal municipal : municipalList) {

            List<Student> studentList =
                    new StudentDaoImpl().queryStudentByMunicipalId(municipal.getId());

            x+=studentList.size();

            for (Student student : studentList) {
                if (Integer.parseInt(student.getYu()) + Integer.parseInt(student.getShu()) +
                        Integer.parseInt(student.getWai()) > 200){
                    eliteStudent ++;
                }
                if (student.getPovertyStudent().equals("1")){
                    poorStudent ++;
                }
            }
        }

        jsonObject.put("eliteStudent" , eliteStudent);
        jsonObject.put("poorStudent" , poorStudent);
        System.out.println(jsonObject+"-----"+x);
        response.getWriter().write(jsonObject.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
