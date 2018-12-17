package com.example.shirostudy.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * @program: shiro-study
 * @description:
 * @author: Simon Zhuang
 * @create: 2018-12-14 11:10
 **/
@Entity
@Table(name = "user")
public class User implements Serializable {

  private static final long serialVersionUID = -7447044369964743420L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String username;

  @Column
  private String password;

  @Column
  private String status;

  @Column
  private String salt;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName="id")}, inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName="id")})
  private List<Role> roles;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public String getCredentialsSalt(){
    return this.username + this.salt;
  }
}
