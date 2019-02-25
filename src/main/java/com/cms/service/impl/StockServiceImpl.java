package com.cms.service.impl;

import com.cms.dao.StockMapper;
import com.cms.dao.StockRecordMapper;
import com.cms.domain.Stock;
import com.cms.domain.StockRecord;
import com.cms.service.StockService;
import com.cms.util.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StockServiceImpl extends BaseService<Stock> implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private StockRecordMapper stockRecordMapper;

    @Override
    public List<Stock> queryList(String key) {
        return stockMapper.queryList(key);
    }

    @Override
    public int checkName(Stock param) {
        return stockMapper.checkName(param);
    }

    @Override
    public void produceStock() {
        List<Stock> list = stockMapper.queryProduce();
        stockMapper.updateNowDay();
        if(list != null && list.size() > 0) {
            StockRecord stockRecord = new StockRecord();
            stockRecord.setType(FieldUtils.IN_STOCK);
            stockRecord.setCreateTime(new Date());
            for (Stock stock : list) {
                stock.setNum(stock.getNum() + stock.getProduceNum());
                stock.setNowDay(1);
                this.updateNotNull(stock);

                stockRecord.setId(null);
                stockRecord.setStockId(stock.getId());
                stockRecord.setNum(stock.getProduceNum());
                stockRecordMapper.insert(stockRecord);
            }
        }
    }
}
