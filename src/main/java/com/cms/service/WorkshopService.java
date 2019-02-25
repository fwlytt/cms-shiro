package com.cms.service;

import com.cms.domain.Workshop;
import com.cms.domain.val.WorkshopVal;

import java.util.List;

public interface WorkshopService extends IService<Workshop> {

    List<WorkshopVal> queryList(String key);

    int checkName(Workshop param);

    List<Workshop> queryInfoList(Integer customerId);
}
