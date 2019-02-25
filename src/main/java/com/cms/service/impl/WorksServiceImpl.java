package com.cms.service.impl;

import com.cms.dao.CmsWorksMapper;
import com.cms.domain.CmsWorks;
import com.cms.domain.Stock;
import com.cms.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorksServiceImpl extends BaseService<CmsWorks> implements WorksService {

    @Autowired
    private CmsWorksMapper cmsWorksMapper;

    @Override
    public List<CmsWorks> queryList(String key) {
        return cmsWorksMapper.queryList(key);
    }

    @Override
    public List<CmsWorks> queryBannerList() {
        return cmsWorksMapper.queryBannerList();
    }

    @Override
    public List<CmsWorks> queryHomeShowList() {
        return cmsWorksMapper.queryHomeShowList();
    }

    @Override
    public List<Map<String, List<CmsWorks>>> queryWorkListGroupByYear() {
        List<Map<String, List<CmsWorks>>> list = new ArrayList<>(); //map中的key就算不同年份的倒序
        Map<String, List<CmsWorks>> map = new HashMap<>();
        List<CmsWorks> works = cmsWorksMapper.queryList(null); //全部的作品
        if (works.size() > 0) {
            List<CmsWorks> workList = new ArrayList<>(); //存放同一年作品的list
            String year = works.get(0).getWorkYear();
            for (CmsWorks work : works) {
                if (year.equals(work.getWorkYear())) { //同一年的作品放在同一个map中
                    workList.add(work);
                } else {
                    map.put(year,workList);
                    list.add(map);
                    map = new HashMap<>();
                    workList = new ArrayList<>();
                    year = work.getWorkYear();
                    workList.add(work);
                }
            }
            map.put(year,workList);
            list.add(map);
        }
        return list;
    }

    @Override
    public List<String> queryYearList() {
        return cmsWorksMapper.queryYearList();
    }

    @Override
    public List<String> queryHomeShowYearList() {
        return cmsWorksMapper.queryHomeShowYearList();
    }

    @Override
    public int countHomeShowByYear(CmsWorks param) {
        return cmsWorksMapper.countHomeShowByYear(param);
    }


}
