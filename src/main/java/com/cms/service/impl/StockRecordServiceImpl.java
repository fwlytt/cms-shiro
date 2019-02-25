package com.cms.service.impl;

import com.cms.dao.StockRecordMapper;
import com.cms.domain.StockRecord;
import com.cms.service.StockRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRecordServiceImpl extends BaseService<StockRecord> implements StockRecordService {

    @Autowired
    private StockRecordMapper stockRecordMapper;

    @Override
    public List<StockRecord> queryList(StockRecord param) {
        return stockRecordMapper.queryList(param);
    }
}
