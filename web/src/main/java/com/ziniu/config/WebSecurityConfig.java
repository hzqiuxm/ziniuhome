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



	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(customUserService());//自动验证
		auth.authenticationProvider(znAuthenticationProvider());//自定义认证



	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
						.antMatchers("/app/commons/**","/img/**","/qiuxm/**","/durid/**").permitAll()
						.anyRequest().authenticated() //4
						.and()
						.formLogin()
							.loginPage("/login")
							.failureUrl("/login?error")
							.permitAll() //5
						.and()
						.logout().permitAll(); //6

		//使用的是JWT，我们这里不需要csrf
		http.csrf().disable().sessionManagement();

	}




}
