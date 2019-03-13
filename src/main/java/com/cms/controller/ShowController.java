package com.cms.controller;

import com.alibaba.fastjson.JSON;
import com.cms.domain.CmsWorks;
import com.cms.domain.Exp;
import com.cms.domain.base.BackCode;
import com.cms.domain.base.Val;
import com.cms.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/show")
public class ShowController {

    @Autowired
    private WorksService worksService;

    @PostMapping(value = "/getBannerList")
    public String getBannerList(){
        Val <List<CmsWorks>> val = new Val<>();
        List<CmsWorks> list = worksService.queryBannerList();
        if (list.size() > 0) {
            val.setData(list);
            val.setInfo(BackCode.SUCCESS, "成功");
        }else {
            val.setInfo(BackCode.FAIL, "数据异常，请刷新后再试");
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/getHomeWorkList")
    public String getHomeWorkList(){
        Val <List<CmsWorks>> val = new Val<>();
        List<CmsWorks> list = worksService.queryHomeShowList();
        if (list.size() > 0) {
            val.setData(list);
            val.setInfo(BackCode.SUCCESS, "成功");
        }else {
            val.setInfo(BackCode.FAIL, "数据异常，请刷新后再试");
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/getWorkList")
    public String getWorkList(){
        Val<List<Map<String ,List<CmsWorks>>>> val = new Val<>();
        List<Map<String ,List<CmsWorks>>> worksList = worksService.queryWorkListGroupByYear();
        if (worksList.size() > 0) {
            val.setData(worksList);
            val.setInfo(BackCode.SUCCESS, "成功");
        }else {
            val.setInfo(BackCode.FAIL, "数据异常，请刷新后再试");
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/getWorkInfo")
    public String getWorkInfo(@RequestBody Integer id){
         Val<CmsWorks> val = new Val<>();
        if (id == null) {
            val.setInfo(BackCode.FAIL, "数据异常，请刷新后再试");
        }else {
            CmsWorks work = worksService.selectByKey(id);
            val.setInfo(BackCode.SUCCESS, "成功");
            val.setData(work);
        }
        return JSON.toJSONString(val);
    }
}
