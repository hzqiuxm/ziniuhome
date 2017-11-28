package com.ziniu.control.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ziniu.data.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author 好事近 haoshijin@ziniuxiaozhu.com
 * @Date 2017/11/22 13:30
 */
public class JwtUser extends User implements UserDetails {
    private Date expiration;

    public JwtUser(String id, String loginName, String password, String showName,
                   List<String> roles, Date expiration) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.showName = showName;
        this.roles = roles;
        this.expiration = expiration;
    }

    //返回分配给用户的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    public String getShowName() {
        return showName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpiration() {
        return expiration;
    }

    //账户是否未过期
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //账户是否未锁定
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //密码是否未过期
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //账户是否激活
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", showName='" + showName + '\'' +
                ", roles=" + roles +
                ", expiration=" + expiration +
                '}';
    }
}
