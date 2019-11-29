package com.cms.dao;

import com.cms.domain.CmsWorks;
import com.cms.util.MyMapper;

import java.util.List;

public interface CmsWorksMapper extends MyMapper<CmsWorks> {

    List<CmsWorks> queryList(String key);

    List<CmsWorks> queryWorkPageList();

    List<CmsWorks> queryBannerList();

    List<CmsWorks> queryHomeShowList();

    List<String> queryYearList();

    List<String> queryHomeShowYearList();

    int countHomeShowByYear(CmsWorks param);
}