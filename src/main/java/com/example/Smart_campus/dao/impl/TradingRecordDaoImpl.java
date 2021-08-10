package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.TradingRecord;
import com.example.Smart_campus.dao.TradingRecordDao;
import java.util.List;

public class TradingRecordDaoImpl extends BaseDao implements TradingRecordDao {

    @Override
    public List<TradingRecord> queryTradingRecordBySchoolCardId(String schoolCardId) {
        String sql = "select * from trading_record where schoolCardId = ?";
        return queryForList(TradingRecord.class , sql , schoolCardId);
    }

    @Override
    public int addTradingRecord(TradingRecord tradingRecord) {
        String sql = "insert into trading_record(schoolCardId,tradingDate,tradingType,tradingSiteId,tradingAmount,tradingDescription) values(?,?,?,?,?,?)";
        return update(sql , tradingRecord.getSchoolCardId() ,
            tradingRecord.getTradingDate(),
            tradingRecord.getTradingType(),
            tradingRecord.getTradingSiteId(),
            tradingRecord.getTradingAmount(),
            tradingRecord.getTradingDescription());
    }

    @Override
    public int deleteTradingRecordById(String tradingRecordId) {
        String sql = "delete from trading_record where id = ?";
        return update(sql , tradingRecordId);
    }
}
