package com.cms.config;

import com.cms.domain.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    //@Override
    //public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
    //    boolean flag;
    //    String path = request.getRequestURI();
    //    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //    UserInfo user=(UserInfo)request.getSession().getAttribute("user");
    //    if(null==user){
    //        response.sendRedirect("/pages/show/article/0");
    //        flag = false;
    //    }else{
    //        flag = true;
    //    }
    //    return flag;
    //}

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}