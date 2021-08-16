package com.example.Smart_campus.utils;

import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

public class ServletUtils {

    /**
     * 设置字符集并接受数据
     * @param request
     * @param response
     * @return 以JSONObject格式返回接收到的数据
     */
    public static void Setting(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取接收的数据
     * @param request
     * @return 返回JSONObject
     */
    public static JSONObject getJSONObject(HttpServletRequest request){
        BufferedReader reader = null;
        JSONObject jsonObject = null;
        try {
            //解析接收的数据
            reader = request.getReader();
            String json = reader.readLine();
            if (json != null){
                jsonObject = new JSONObject(json);
            }else {
                jsonObject = new JSONObject();
                Enumeration<String> parameterNames = request.getParameterNames();
                if (parameterNames != null){
                    for (Enumeration<String> it = parameterNames; it.hasMoreElements(); ) {
                        String key = it.nextElement();
                        String parameter = request.getParameter(key);
                        jsonObject.put(key , parameter);
                    }
                }
            }
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 获取图片的访问地址
     * @param request
     * @return 返回图片的访问地址
     */
    public static String getImageUrl(HttpServletRequest request , String imageName){
        StringBuffer requestURL = request.getRequestURL();
        String servletPath = request.getServletPath();
        int index = requestURL.indexOf(servletPath);
        return requestURL.delete(index+1 , requestURL.length())+"images/"+imageName;
    }

    /**
     * 为返回结果添加失败，成功提示
     * @param jsonObject 要设置数据的对象
     * @param isOk 是否成功
     */
    public static void isOk(JSONObject jsonObject , boolean isOk){
        if (isOk){
            jsonObject.put("msg" , "操作成功");
            jsonObject.put("code" , "200");
        }else {
            jsonObject.put("msg" , "操作失败");
            jsonObject.put("code" , "500");
        }
    }

}
