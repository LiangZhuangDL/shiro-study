package com.example.shirostudy.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @program: shiro-study
 * @description:
 * @author: Simon Zhuang
 * @create: 2018-12-14 11:25
 **/

@Entity
@Table(name = "permission")
public class Permission implements Serializable {

  private static final long serialVersionUID = -4756671388301221173L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String permisson;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "permission_role", joinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
  private List<Role> roles;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public String getPermisson() {
    return permisson;
  }

  public void setPermisson(String permisson) {
    this.permisson = permisson;
  }
}
