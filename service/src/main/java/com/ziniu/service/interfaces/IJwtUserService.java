package com.ziniu.service.interfaces;

import com.ziniu.data.entity.JwtUmUserBase;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IJwtUserService extends UserDetailsService{

    @Override
    JwtUmUserBase loadUserByUsername(String username) throws UsernameNotFoundException;

}
