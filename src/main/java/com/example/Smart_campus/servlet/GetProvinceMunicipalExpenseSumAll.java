package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.CampusCard;
import com.example.Smart_campus.bean.Municipal;
import com.example.Smart_campus.bean.Province;
import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.impl.CampusCardDaoImpl;
import com.example.Smart_campus.dao.impl.MunicipalDaoImpl;
import com.example.Smart_campus.dao.impl.ProvinceDaoImpl;
import com.example.Smart_campus.dao.impl.StudentDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "GetProvinceMunicipalExpenseSumAll", value = "/GetProvinceMunicipalExpenseSumAll")
public class GetProvinceMunicipalExpenseSumAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ServletUtils.Setting(request, response);

        ProvinceDaoImpl provinceDao = new ProvinceDaoImpl();
        MunicipalDaoImpl municipalDao = new MunicipalDaoImpl();
        StudentDaoImpl studentDao = new StudentDaoImpl();
        CampusCardDaoImpl campusCardDao = new CampusCardDaoImpl();

        System.out.println("加载成功。。。。。。。。。。。。。");

        List<Province> provinceList = provinceDao.queryProvinceAll();
        if (provinceList != null){
            System.out.println("provinceList加载成功。。。。。。。。。。。。。");
        }
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Province province : provinceList) {
            JSONObject jsonObject1 = new JSONObject(province);
            JSONArray jsonArray1 = new JSONArray();
            List<Municipal> municipalList = municipalDao
                .queryMunicipalByProvinceId(province.getProvinceId());
            if (municipalList != null){
                System.out.println(province.getProvinceName()+"municipalList加载成功。。。。。。。。。。。。。");
            }
            for (Municipal municipal : municipalList) {
                JSONObject jsonObject2 = new JSONObject(municipal);
                List<Student> studentList = studentDao
                    .queryStudentByMunicipalId(municipal.getId());
                if (studentList != null){
                    System.out.println(municipal.getMunicipalName()+"studentList加载成功。。。。。。。。。。。。。");
                }
                int expenditure = 0;
                for (Student student : studentList) {
                    CampusCard campusCard = campusCardDao
                        .queryCampusCardBySchoolCardId(student.getSchoolCard());
                    expenditure += campusCard.getExpenditure();
                }
                jsonObject2.put("expenditure" , expenditure);
                jsonArray1.put(jsonObject2);
            }
            jsonObject1.put("municipalExpenditure" , jsonArray1);
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
