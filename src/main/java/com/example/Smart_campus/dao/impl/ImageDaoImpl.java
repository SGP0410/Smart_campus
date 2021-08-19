package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.Image;
import com.example.Smart_campus.dao.ImageDao;

import java.util.List;

public class ImageDaoImpl extends BaseDao implements ImageDao {
    @Override
    public List<Image> queryImageAll() {
        String sql = "select * from image";
        return queryForList(Image.class , sql);
    }
}
