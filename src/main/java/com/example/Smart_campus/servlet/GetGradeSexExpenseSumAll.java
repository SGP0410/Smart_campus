package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.CampusCard;
import com.example.Smart_campus.bean.Student;
import com.example.Smart_campus.dao.impl.CampusCardDaoImpl;
import com.example.Smart_campus.dao.impl.StudentDaoImpl;
import com.example.Smart_campus.utils.ServletUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "GetGradeSexExpenseSumAll", value = "/GetGradeSexExpenseSumAll")
public class GetGradeSexExpenseSumAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ServletUtils.Setting(request, response);

        StudentDaoImpl studentDao = new StudentDaoImpl();
        CampusCardDaoImpl campusCardDao = new CampusCardDaoImpl();


        List<Student> studentList = studentDao.queryStudentAll();
        Map<String , List<Student>> studentMap = new HashMap<>();
        //学生按年级分类
        for (Student student : studentList) {
            List<Student> students;
            if (studentMap.get(student.getGrade()) == null){
                students = new ArrayList<>();
            }else {
                students = studentMap.get(student.getGrade());
            }
            students.add(student);
            studentMap.put(student.getGrade() , students);
        }

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<String> keys = new ArrayList<>(studentMap.keySet());
        for (String key : keys) {
            JSONObject jsonObject1 = new JSONObject();
            int manExpenditure = 0;
            int womanExpenditure = 0;
            //计算每一年级男生和女生的消费金额
            for (Student student : studentMap.get(key)) {
                CampusCard campusCard = campusCardDao
                    .queryCampusCardBySchoolCardId(student.getSchoolCard());
                if (student.getSex().equals("男")){
                    manExpenditure += campusCard.getBalance();
                }else if (student.getSex().equals("女")){
                    womanExpenditure += campusCard.getBalance();
                }
            }
            jsonObject1.put("grade" , key);
            jsonObject1.put("manExpenditure" , manExpenditure);
            jsonObject1.put("womanExpenditure" , womanExpenditure);
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
