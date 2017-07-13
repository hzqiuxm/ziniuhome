package com.ziniu.domain;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/6 0006 21:43
 */
public class UmUserBase implements UserDetails{

    private Integer userId;
    private String UserName;
    private String cellNum;
    private String Password;
    private Byte status;
    private Date gmtCreate;
    private Date gmtModfiy;
    private String reserve;
    private List<UmSecUserRole> umsecUserRoles;

    public List<UmSecUserRole> getUmsecUserRoles() {
        return umsecUserRoles;
    }

    public void setUmsecUserRoles(List<UmSecUserRole> umsecUserRoles) {
        this.umsecUserRoles = umsecUserRoles;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
    @Override
    public String getUsername() {
        return UserName;
    }

    public String getCellNum() {
        return cellNum;
    }

    public void setCellNum(String cellNum) {
        this.cellNum = cellNum;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        List<UmSecUserRole> umSecUserRoles = this.getUmsecUserRoles();
        for (UmSecUserRole secUserRole : umSecUserRoles){
            auths.add(new SimpleGrantedAuthority(secUserRole.getUmSecRole().getRoleName()));
        }

        return auths;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModfiy() {
        return gmtModfiy;
    }

    public void setGmtModfiy(Date gmtModfiy) {
        this.gmtModfiy = gmtModfiy;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
