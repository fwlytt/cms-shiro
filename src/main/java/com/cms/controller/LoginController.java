package com.cms.controller;

import com.cms.domain.UserInfo;
import com.cms.domain.base.Val;
import com.cms.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录操作
     **/
    @PostMapping(value = "/doLogin")
    public String doLogin(@RequestParam("id") String id, @RequestParam("password") String password, HttpServletRequest request, Model model) {
        Val val = new Val();
        //if (!StringUtils.isEmpty(param.getId()) && !StringUtils.isEmpty(param.getPassword())) {
        //    UserInfo user = loginService.selectByKey(param.getId());
        //    if (user == null) {
        //        val.setInfo(BackCode.FAIL, "该用户不存在");
        //    } else if (user.getPassword().equals(param.getPassword())) {
        //        val.setCode(BackCode.SUCCESS);
        //        request.getSession().setAttribute("user", param);
        //        request.getSession().setMaxInactiveInterval(3600 * 6);
        //        return JSON.toJSONString(val);
        //    } else {
        //        val.setInfo(BackCode.FAIL, "用户密码错误");
        //    }
        //} else {
        //    val.setInfo(BackCode.FAIL, " 请输入账号密码");
        //}

        UsernamePasswordToken token = new UsernamePasswordToken(id, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            UserInfo param = new UserInfo();
            subject.login(token);
            request.getSession().setAttribute("user", param);
            request.getSession().setMaxInactiveInterval(3600 * 6);
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("loginMsg", "账号密码错误！");
            return "login";
        }
    }
}
