package com.cms.service;

import com.cms.domain.StockRecord;

import java.util.List;

public interface StockRecordService extends IService<StockRecord> {

    List<StockRecord> queryList(StockRecord param);

}
