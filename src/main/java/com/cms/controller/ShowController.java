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

@RestController
@RequestMapping(value = "/show")
public class ShowController {

    @Autowired
    private WorksService worksService;

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
