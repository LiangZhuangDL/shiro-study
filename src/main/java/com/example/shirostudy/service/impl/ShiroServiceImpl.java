package com.example.shirostudy.service.impl;

import com.example.shirostudy.common.Result;
import com.example.shirostudy.entity.User;
import com.example.shirostudy.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @program: shiro-study
 * @description:
 * @author: Simon Zhuang
 * @create: 2018-12-17 10:26
 **/
@Service
public class ShiroServiceImpl implements ShiroService {

  @Override
  public Result<String> login(User user) {
    Subject subject = SecurityUtils.getSubject();
    try{
      subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
    }catch (AuthenticationException authenticationException){
      return new Result<String>().fail();
    }
    return new Result<String>().sucess();
  }
}
