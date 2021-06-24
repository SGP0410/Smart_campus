package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.CampusCard;
import java.util.List;

public interface CampusCardDao {

    public List<CampusCard> queryCampusCardAll();

    public CampusCard queryCampusCardBySchoolCardId(String schoolCardId);

    public int updateCampusCardForBalance(CampusCard campusCard);

    public int updateCampusCardForExpenditure(CampusCard campusCard);

    public int addCampusCard(CampusCard campusCard);

    public int deleteCampusCardBySchoolCardId(String schoolCardId);
}
