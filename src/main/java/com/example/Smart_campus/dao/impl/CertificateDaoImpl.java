package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.Certificate;
import com.example.Smart_campus.dao.CertificateDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/12 15:29 星期四
 * @Description com.example.Smart_campus.dao.impl
 */
public class CertificateDaoImpl extends BaseDao implements CertificateDao {

    @Override
    public List<Certificate> querySchoolCard(String schoolcard) {
        String sql = "select * from certificate where schoolcard = ?";
        return queryForList(Certificate.class, sql, schoolcard);
    }

    @Override
    public int addCertificate(Certificate certificate) {
        String sql = "insert into certificate(title,level,time,member,grade,teacher,years,name,schoolcard,state,classid) values(?,?,?,?,?,?,?,?,?,?,?)";
        return update(sql,
                certificate.getTitle(),
                certificate.getLevel(),
                certificate.getTime(),
                certificate.getMember(),
                certificate.getGrade(),
                certificate.getTeacher(),
                certificate.getYears(),
                certificate.getName(),
                certificate.getSchoolcard(),
                certificate.getState(),
                certificate.getClassid());
    }

    @Override
    public int updateCertificate(String state, String id) {
        String sql = "update certificate set state = ? where id = ?";
        return update(sql,state,id);
    }

    @Override
    public List<Certificate> queryClassid(String classid) {
        String sql = "select * from certificate where classid = ?";
        return queryForList(Certificate.class,sql,classid);
    }

}
