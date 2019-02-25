package com.cms.shiro;

import com.cms.domain.UserInfo;
import com.cms.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class Realm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;//这边是界面的登陆数据，将数据封装成token
        String username = usernamePasswordToken.getUsername();
        char[] password = usernamePasswordToken.getPassword();
        System.out.print("password-----------------");
        for (char c : password) {
            System.out.print(c);
        }
        UserInfo user = loginService.selectByKey(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
}
