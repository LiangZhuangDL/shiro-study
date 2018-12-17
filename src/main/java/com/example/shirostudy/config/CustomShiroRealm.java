package com.example.shirostudy.config;

import com.example.shirostudy.entity.User;
import com.example.shirostudy.repository.UserRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

/**
 * @program: shiro-study
 * @description:
 * @author: Simon Zhuang
 * @create: 2018-12-14 14:00
 **/
public class CustomShiroRealm extends AuthorizingRealm {

  @Autowired
  private UserRepository userRepository;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
    User user = (User)principals.getPrimaryPrincipal();
    user.getRoles().forEach(role -> {
      simpleAuthorizationInfo.addRole(role.getName());
      role.getPermissions().forEach(permission -> {
        simpleAuthorizationInfo.addStringPermission(permission.getPermisson());
      });
    });
    return simpleAuthorizationInfo;
  }

  @SuppressWarnings("UnnecessaryLocalVariable")
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    String username = (String) token.getPrincipal();
    User user = userRepository.findByUsername(username);
    if(ObjectUtils.isEmpty(user)){
      return null;
    }
    SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
    return simpleAuthenticationInfo;
  }
}
