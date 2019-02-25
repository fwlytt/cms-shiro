package com.cms;

import com.cms.domain.UserInfo;
import com.cms.service.LoginService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter1ApplicationTests {

    @Autowired
    private LoginService loginService;

    @Test
    public void contextLoads() {
        //UserInfo user = loginService.selectByKey("10000");
        //System.out.println(user.getName());

         String a = new Md5Hash("111111").toHex();
        System.out.println("pass--------------------" + a);
    }

}
