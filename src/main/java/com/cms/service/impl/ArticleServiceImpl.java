package com.cms.service.impl;

import com.cms.dao.ArticleMapper;
import com.cms.dao.CmsWorksMapper;
import com.cms.domain.Article;
import com.cms.domain.CmsWorks;
import com.cms.service.ArticleService;
import com.cms.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends BaseService<Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> queryList(String key) {
        return articleMapper.queryList(key);
    }

    @Override
    public List<Article> queryFullList() {
        return articleMapper.queryFullList();
    }

    @Override
    public List<Article> queryHomeShowList() {
        return articleMapper.queryHomeShowList();
    }
}
