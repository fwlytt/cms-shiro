package com.cms.service;

import com.cms.domain.CmsWorks;

import java.util.List;
import java.util.Map;

public interface WorksService extends IService<CmsWorks> {

    List<CmsWorks> queryList(String key);

    List<CmsWorks> queryBannerList();

    List<CmsWorks> queryHomeShowList();

    List<Map<String, List<CmsWorks>>> queryWorkListGroupByYear();

    List<String> queryYearList();

    List<String> queryHomeShowYearList();

    //统计该年份作品是否有显示在首页
    int countHomeShowByYear(CmsWorks param);
}