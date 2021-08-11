package com.example.Smart_campus.servlet;

import com.example.Smart_campus.bean.ClassSchedule;
import com.example.Smart_campus.bean.Teacher;
import com.example.Smart_campus.dao.impl.ClassScheduleDaoImpl;
import com.example.Smart_campus.dao.impl.TeacherDaoImpl;
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
 * @date 2021/8/9 16:36 星期一
 * 通过班级id查询课表
 */
@WebServlet(name = "GetClassSchedule",value = "/GetClassSchedule")
public class ClassScheduleGet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.Setting(req,resp);
        JSONObject jsonObject = ServletUtils.getJSONObject(req);
        List<ClassSchedule> classSchedules = new ClassScheduleDaoImpl().queryClassSchedule(jsonObject.optString("classid"));
        List<Teacher> teachers = new TeacherDaoImpl().queryTeacherList();
        JSONObject jsonObject1 = new JSONObject();

        for (ClassSchedule classSchedule : classSchedules) {
            for (Teacher teacher : teachers) {
                if (classSchedule.getTeacher().equals(teacher.getId())){
                    classSchedule.setCourse(teacher.getCourse());
                    classSchedule.setName(teacher.getName());
                    break;
                }
            }
        }
        if (classSchedules != null){
            jsonObject1.put("data",new JSONArray(classSchedules));
        }
        ServletUtils.isOk(jsonObject1,classSchedules!=null);
        resp.getWriter().write(jsonObject1.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
