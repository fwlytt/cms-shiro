package com.cms.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cms.domain.Article;
import com.cms.domain.Exp;
import com.cms.domain.Stock;
import com.cms.domain.base.BackCode;
import com.cms.domain.base.Page;
import com.cms.domain.base.Val;
import com.cms.service.ArticleService;
import com.cms.service.ExpService;
import com.cms.util.FieldUtils;
import com.cms.util.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/exp")
public class ExpController {

    @Autowired
    private ExpService expService;


    @PostMapping(value = "/getList")
    public String getList(@RequestBody Page page) {
        Val<List<Exp>> val = new Val<>();
        if (StringUtils.isEmpty(page.getField())) {
            PageHelper.startPage(page.getPage(), page.getLimit());
        } else {
            //由于排序字段直接拼接至sql上,所以需要把驼峰转化为下划线
            String field = Utils.camelToUnderline(page.getField());
            PageHelper.startPage(page.getPage(), page.getLimit(),
                    field + (page.getOrder() == null?"":" " +page.getOrder()));
        }
        //PageHelper.startPage(page, limit);
        List<Exp> list = expService.queryList();
        if (list != null && list.size() > 0) {
            PageInfo<Stock> info = new PageInfo(list);
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
            Exp param = new Exp();
            param.setId(id);
            param.setStatus(FieldUtils.UNABLE);
            expService.updateNotNull(param);
            val.setInfo(BackCode.SUCCESS, "成功");
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/insert")
    public String insert(@RequestBody Exp param) {
        Val val = new Val();
        if (param == null) {
            val.setInfo(BackCode.FAIL, "数据异常,请刷新后再试");
        }else if (StringUtils.isEmpty(param.getExpYear()) || StringUtils.isEmpty(param.getContent())) {
            val.setInfo(BackCode.FAIL, "必填项不能为空");
        } else {
            param.setCreateTime(new Date());
            param.setStatus(FieldUtils.ABLE);

            expService.save(param);
            val.setInfo(BackCode.SUCCESS, "成功");
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/getInfo")
    public String getInfo(@RequestBody Integer id) {
        Val<Exp> val = new Val<>();
        if (id == null) {
            val.setInfo(BackCode.FAIL, "数据异常，请刷新后再试");
        }else {
            Exp exp = expService.selectByKey(id);
            val.setInfo(BackCode.SUCCESS, "成功");
            val.setData(exp);
        }
        return JSON.toJSONString(val);
    }

    @PostMapping(value = "/update")
    public String update(@RequestBody Exp param) {
        Val val = new Val();
        if (param == null || param.getId() == null) {
            val.setInfo(BackCode.FAIL, "数据异常,请刷新后再试");
        } else if (StringUtils.isEmpty(param.getExpYear()) || StringUtils.isEmpty(param.getContent())) {
            val.setInfo(BackCode.FAIL, "必填项不能为空");
        } else {
            Exp exp = expService.selectByKey(param.getId());
            param.setCreateTime(exp.getCreateTime());
            param.setStatus(exp.getStatus());

            expService.updateAll(param);
            val.setInfo(BackCode.SUCCESS, "成功");
        }
        return JSON.toJSONString(val);
    }

}
