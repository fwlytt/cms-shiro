package com.cms.dao;

import com.cms.domain.Workshop;
import com.cms.domain.val.WorkshopVal;
import com.cms.util.MyMapper;

import java.util.List;

public interface WorkshopMapper extends MyMapper<Workshop> {

    List<WorkshopVal> queryList(String key);

    int checkName(Workshop param);

    List<Workshop> queryInfoList(Integer customerId);
}