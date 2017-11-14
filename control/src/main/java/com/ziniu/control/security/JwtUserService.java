package com.ziniu.control.security;

import com.ziniu.data.entity.User;
import com.ziniu.data.repository.UserInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Service
public class JwtUserService implements UserDetailsService{

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public JwtUserBase loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过username去找对应的用户信息
        User user = userInfoRepository.findUserByLoginName(username);
        if(user == null){
            throw new UsernameNotFoundException("can not find loginName in database, please try again!");
        }
        System.out.println("用户:"+username+"，拥有的权限："+user.getRoles());
        JwtUserBase jwtUserBase = new JwtUserBase();
        BeanUtils.copyProperties(user,jwtUserBase);
        return jwtUserBase;
    }
}
