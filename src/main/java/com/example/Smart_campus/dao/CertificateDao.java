package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.Certificate;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/12 15:28 星期四
 * @Description com.example.Smart_campus.dao
 */
public interface CertificateDao {

    public List<Certificate> querySchoolCard(String schoolcard);

    public int addCertificate(Certificate certificate);

    public int updateCertificate(String state,String id);

    public List<Certificate> queryClassid(String classid);
}
