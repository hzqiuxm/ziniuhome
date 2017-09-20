package com.ziniu.config;

import com.ziniu.security.ZnAuthenticationProvider;
import com.ziniu.service.Impl.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{//1

	@Bean
	UserDetailsService customUserService(){ //2
		return new CustomUserService();
	}

	@Bean
	ZnAuthenticationProvider znAuthenticationProvider(){
		return new ZnAuthenticationProvider();
	}


//	@Bean
//	public SpringTemplateEngine templateEngine(TemplateResolver templateResolver){
//
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver);
//		templateEngine.addDialect(new SpringStandardDialect());
//		return templateEngine;
//	}
//
//	@Bean
//	public TemplateResolver templateResolver(){
//		return new TemplateResolver();
//	}


	/**
	 * 认证信息管理
	 * @param auth
	 * @throws Exception
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(customUserService());//自动验证
		auth.authenticationProvider(znAuthenticationProvider());//自定义认证
//		auth.inMemoryAuthentication()
//				.withUser("qiuxm").password("123456").roles("admin"); //认证信息存储在内存中



	}


	/**
	 * 安全认证配置
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
						.antMatchers("/app/commons/**","/img/**","/qiuxm/**","/durid/**","/**").permitAll()
						.anyRequest().authenticated() //4
						.and()
						.formLogin()  //基于Form表单登录验证
							.loginPage("/login") //自定义登录页面
							.failureUrl("/login?error")
							.permitAll() //5
						.and()
						.logout().permitAll(); //6
		http.headers().frameOptions().disable();

		//使用的是JWT，我们这里不需要csrf
		http.csrf().disable().sessionManagement();

	}






}
