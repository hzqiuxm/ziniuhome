//package com.ziniu.service.Impl;
//
//import com.ziniu.dao.SysUserRepository;
//import com.ziniu.repository.SysUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//
//public class CustomUserService implements UserDetailsService { //1
//	@Autowired
//	SysUserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) { //2
//
//		SysUser user = userRepository.findByUsername(username);
//		if(user == null){
//			throw new UsernameNotFoundException("用户名不存在");
//		}
//
//		return user; //3
//	}
//
//}
