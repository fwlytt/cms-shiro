package com.cms.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cms.domain.CmsWorks;
import com.cms.domain.base.BackCode;
import com.cms.domain.base.Page;
import com.cms.domain.base.Val;
import com.cms.service.WorksService;
import com.cms.util.FieldUtils;
import com.cms.util.UploadUtil;
import com.cms.util.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/works")
public class WorksController {

    @Autowired
    private WorksService worksService;

    @Value("${cms.uploadPath}")
    private String uploadPath;


    @PostMapping(value = "/getList")
    public String getList(@RequestBody Page page) {
        Val<List<CmsWorks>> val = new Val<>();
        if (StringUtils.isEmpty(page.getField())) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        } else {
            //由于排序字段直接拼接至sql上,所以需要把驼峰转化为下划线
            String field = Utils.camelToUnderline(page.getField());
            PageHelper.startPage(page.getPage(), page.getLimit(),
                    field + (page.getOrder() == null ? "" : " " + page.getOrder()));
        }
        //PageHelper.startPage(page, limit);
        List<CmsWorks> list = worksService.queryList(page.getKey());
        if (list != null && list.size() > 0) {
            PageInfo<CmsWorks> info = new PageInfo(list);
            val.setData(list);
            val.setCount(info.getTotal());
            val.setInfo(BackCode.SUCCESS, "成功");
        } else {
            val.setCount(0L);
            val.setInfo(BackCode.FAIL, "暂无数据");
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestBody Integer id) {
        Val val = new Val();
        if (id == null) {
            val.setInfo(BackCode.FAIL, "数据异常，请刷新后再试");
        } else {
            CmsWorks param = new CmsWorks();
            param.setId(id);
            param.setStatus(FieldUtils.UNABLE);
            worksService.updateNotNull(param);
            val.setInfo(BackCode.SUCCESS, "成功");
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/insert")
    public String insert(@RequestBody CmsWorks param) {
        Val val = new Val();
        if (param == null) {
            val.setInfo(BackCode.FAIL, "数据异常,请刷新后再试");
        } else if (param.getWorkYear() == null ||
                StringUtils.isEmpty(param.getPicUrl())) {
            val.setInfo(BackCode.FAIL, "必填项不能为空");
        }else if (FieldUtils.YES.equals(param.getHomeShow()) &&
                worksService.countHomeShowByYear(param) > 0) {
            val.setInfo(BackCode.FAIL, "同一年份作品不能同时显示在首页");
        } else {
            param.setCreateTime(new Date());
            param.setStatus(FieldUtils.ABLE);

            worksService.save(param);
            val.setInfo(BackCode.SUCCESS, "成功");
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/getInfo")
    public String getInfo(@RequestBody Integer id) {
        Val<CmsWorks> val = new Val<>();
        if (id == null) {
            val.setInfo(BackCode.FAIL, "数据异常，请刷新后再试");
        } else {
            CmsWorks cmsWorks = worksService.selectByKey(id);
            val.setInfo(BackCode.SUCCESS, "成功");
            val.setData(cmsWorks);
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/update")
    public String update(@RequestBody CmsWorks param) {
        Val val = new Val();
        if (param == null || param.getId() == null) {
            val.setInfo(BackCode.FAIL, "数据异常,请刷新后再试");
        } else if (param.getWorkYear() == null) {
            val.setInfo(BackCode.FAIL, "必填项不能为空");
        } else if (FieldUtils.YES.equals(param.getHomeShow()) &&
                worksService.countHomeShowByYear(param) > 0) {
            val.setInfo(BackCode.FAIL, "同一年份作品不能同时显示在首页");
        } else {
            CmsWorks cmsWorks = worksService.selectByKey(param.getId());

            if (StringUtils.isEmpty((param.getPicUrl()))) {
                param.setPicUrl(cmsWorks.getPicUrl());
            }
            param.setCreateTime(cmsWorks.getCreateTime());
            param.setStatus(cmsWorks.getStatus());

            worksService.updateAll(param);
            val.setInfo(BackCode.SUCCESS, "成功");
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/uploadPic")
    public String uploadPic(@RequestBody MultipartFile file) {
        Val val = new Val();
        try {
            //图片的存储位置
            String image = UploadUtil.uploadFile(file, uploadPath);
            val.setInfo(BackCode.SUCCESS, "成功");
            val.setData(image);
        } catch (Exception e) {
            val.setInfo(BackCode.SUCCESS, "上传失败，请刷新后再试");
            e.printStackTrace();
        }
        return JSON.toJSONString(val);
    }
}
