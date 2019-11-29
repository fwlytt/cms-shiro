package com.cms.controller;

import com.cms.domain.Article;
import com.cms.domain.CmsWorks;
import com.cms.domain.Exp;
import com.cms.service.ArticleService;
import com.cms.service.ExpService;
import com.cms.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    @Autowired
    private WorksService worksService;

    @Autowired
    private ExpService expService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "home")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "pages/{page}")
    public String pages(@PathVariable String page){
        return "pages/" + page;
    }

    @RequestMapping(value = "pages/show/{page}/{fieldId}")
    public String pagesShow(@PathVariable String page, @PathVariable String fieldId, Model model){
        switch (page) {

            //首页
            case "index":
                List<CmsWorks> banners = worksService.queryBannerList();
                List<CmsWorks> works = worksService.queryHomeShowList();
                List<String> workYears = worksService.queryHomeShowYearList();
                List<Exp> exps = expService.queryList();
                List<Article> articles = articleService.queryHomeShowList();

                model.addAttribute("fieldId", fieldId);
                model.addAttribute("banners", banners);
                model.addAttribute("works", works);
                model.addAttribute("workYears", workYears);
                model.addAttribute("exps", exps);
                model.addAttribute("articles", articles);
                break;
            //作品
            case "work":
                //List<Map<Integer ,List<CmsWorks>>> worksList = worksService.queryWorkListGroupByYear();
                List<String> years = worksService.queryYearList();
                //model.addAttribute("vals", worksList);
                model.addAttribute("years", years);
                break;
            //经历
            //case "exp":
            //    List<Exp> expList = expService.queryList();
            //    model.addAttribute("vals", expList);
            //    break;
            //评论文章
            case "article":
                List<Article> articleList = articleService.queryFullList();
                model.addAttribute("vals", articleList);
                break;
            case "workimg":
                CmsWorks work = worksService.selectByKey(Integer.parseInt(fieldId));
                model.addAttribute("val", work);
                break;
                default:
                    break;
        }
        model.addAttribute("fieldId", fieldId);
        return "pages/show/" + page;
    }

    @RequestMapping(value = "pages/works/{page}")
    public String pagesWorks(@PathVariable String page){
        return "pages/works/" + page;
    }

    @RequestMapping(value = "pages/article/{page}")
    public String pagesArticle(@PathVariable String page){
        return "pages/article/" + page;
    }

    @RequestMapping(value = "pages/exp/{page}")
    public String pagesExp(@PathVariable String page){
        return "pages/exp/" + page;
    }

    @RequestMapping(value = "pages/views/{page}")
    public String pagesViews(@PathVariable String page){
        return "pages/views/" + page;
    }

    @RequestMapping(value = "pages/views/{content}/{page}")
    public String pagesViews(@PathVariable String content, @PathVariable String page){
        return "pages/views/" +content +"/" + page;
    }
}
