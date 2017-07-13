package com.ziniu.service.Impl;

import com.ziniu.dao.UmUserBaseDao;
import com.ziniu.domain.UmSecUserRole;
import com.ziniu.domain.UmUserBase;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserService implements UserDetailsService { //1
	private Logger log = Logger.getLogger(this.getClass());
//	@Autowired
//	SysUserRepository userRepository;
	@Autowired
	UmUserBaseDao umUserBaseDao;

//	@Override
//	public UserDetails loadUserByUsername(String username) { //2
//
//		SysUser user = userRepository.findByUsername(username);
//		if(user == null){
//			throw new UsernameNotFoundException("用户名不存在");
//		}
//
//		List<SysRole> lists = user.getRoles();
//
//		for(SysRole sysRole : lists){
//			System.out.println("user roles: " + sysRole.getName() );
//		}
//		return user; //3
//	}


	@Override
	public UserDetails loadUserByUsername(String username) {

		log.info("loadUserByUsername.username==" + username);
		UmUserBase umUserBase = umUserBaseDao.findByUserName(username);
		if(null == umUserBase){
			log.error("用户名不存在!");
			throw new UsernameNotFoundException("该用户名不存在");
		}

		List<UmSecUserRole> lists = umUserBase.getUmsecUserRoles();
		if(log.isInfoEnabled()){
			for (UmSecUserRole umSecUserRole : lists){
				log.info("user roles: " + umSecUserRole.getUmSecRole().getRoleName());
			}
		}


		return umUserBase;
	}
}
