package com.example.shirostudy.common;

/**
 * @program: shiro-study
 * @description:
 * @author: Simon Zhuang
 * @create: 2018-12-17 09:19
 **/
public class Result<T> {

  private String code;

  private String message;

  private T data;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Result(String code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public Result() {
  }

  public Result<T> sucess(){
    return new Result<>("200", "操作成功", null);
  }

  public Result<T> fail(){
    return new Result<>("400", "操作失败", null);
  }
}
