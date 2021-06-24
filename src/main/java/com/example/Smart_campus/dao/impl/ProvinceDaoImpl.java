package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.Province;
import com.example.Smart_campus.dao.ProvinceDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/7 16:29 星期一
 */

public class ProvinceDaoImpl extends BaseDao implements ProvinceDao {

    /**
     * 查询所有省
     * @return
     */
    @Override
    public List<Province> queryProvinceAll() {
        String sql = "select * from province";
        return queryForList(Province.class,sql);
    }

    @Override
    public Province queryProvinceByProvinceName(String provinceName) {
        String sql = "select * from province where provinceName = ?";
        return queryForOne(Province.class , sql , provinceName);
    }

}
