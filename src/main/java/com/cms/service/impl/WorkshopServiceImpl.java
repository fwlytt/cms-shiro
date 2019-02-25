package com.cms.service.impl;

import com.cms.dao.WorkshopMapper;
import com.cms.domain.Workshop;
import com.cms.domain.val.WorkshopVal;
import com.cms.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkshopServiceImpl extends BaseService<Workshop> implements WorkshopService {

    @Autowired
    private WorkshopMapper workshopMapper;

    @Override
    public List<WorkshopVal> queryList(String key) {
        return workshopMapper.queryList(key);
    }

    @Override
    public int checkName(Workshop param) {
        return workshopMapper.checkName(param);
    }

    @Override
    public List<Workshop> queryInfoList(Integer customerId) {
        return workshopMapper.queryInfoList(customerId);
    }
}
