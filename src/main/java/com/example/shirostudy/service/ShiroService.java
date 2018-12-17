package com.example.shirostudy.service;

import com.example.shirostudy.common.Result;
import com.example.shirostudy.entity.User;

public interface ShiroService {
  Result<String> login(User user);
}
