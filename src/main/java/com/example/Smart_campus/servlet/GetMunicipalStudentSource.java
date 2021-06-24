package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.Municipal;
import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.impl.MunicipalDaoImpl;
import com.example.Smart_campus.dao.impl.StudentDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 获取市的生源信息
 */
@WebServlet(name = "GetMunicipalStudentSource", value = "/GetMunicipalStudentSource")
public class GetMunicipalStudentSource extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.Setting(request, response);
        Municipal municipal = new MunicipalDaoImpl().queryMunicipalByName(request.getParameter("municipalName"));
        if (municipal == null){
            System.out.println("市名称参数不对");
            return;
        }
        List<Student> studentList =
                new StudentDaoImpl().queryStudentByMunicipalId(municipal.getId());

        System.out.println("MunicipalId="+municipal.getId()+"结果："+studentList);

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

        JSONObject jsonObject = new JSONObject(new Gson().toJson(municipal));
        jsonObject.put("eliteStudent" , eliteStudent);
        jsonObject.put("poorStudent" , poorStudent);
        System.out.println(jsonObject);
        response.getWriter().write(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
