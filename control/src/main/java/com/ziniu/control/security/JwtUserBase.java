package com.ziniu.control.security;

import com.ziniu.data.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by yeoman on 2017/11/6.
 */
public class JwtUserBase extends User implements UserDetails {

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        List<String> umSecUserRoles = this.getRoles();
        for (String secUserRole : umSecUserRoles){
            auths.add(new SimpleGrantedAuthority(secUserRole));
        }
        return auths;
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
