package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.Province;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/7 16:29 星期一
 */

public interface ProvinceDao {

    /**
     * 查询所有省
     * @return
     */
    public List<Province> queryProvinceAll();

    public Province queryProvinceByProvinceName(String provinceName);

}
