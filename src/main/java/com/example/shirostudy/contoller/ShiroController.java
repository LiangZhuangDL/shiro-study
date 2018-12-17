package com.example.shirostudy.contoller;

import com.example.shirostudy.common.Result;
import com.example.shirostudy.entity.User;
import com.example.shirostudy.service.ShiroService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: shiro-study
 * @description:
 * @author: Simon Zhuang
 * @create: 2018-12-14 17:16
 **/
@RestController
public class ShiroController {

  @Autowired
  private ShiroService shiroService;

  @PostMapping(name = "/login")
  public Result<String> login(HttpServletRequest request,@RequestBody User user) throws Exception {
    String exception = (String) request.getAttribute("shiroLoginFailure");
    return shiroService.login(user);
  }
}
