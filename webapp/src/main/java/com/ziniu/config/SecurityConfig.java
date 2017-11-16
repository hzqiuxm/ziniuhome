package com.ziniu.config;

import com.ziniu.control.security.MyAuthenticationProvider;
import com.ziniu.control.security.jwtfilter.JwtAuthenticationTokenFilter;
import com.ziniu.control.security.jwtfilter.JwtTokenUtil;
import com.ziniu.control.security.JwtUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true) //http://www.mamicode.com/info-detail-1150834.html
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    JwtUserService jwtUserService(){
        return new JwtUserService();
    }

    @Bean
    MyAuthenticationProvider myAuthenticationProvider(){
        return new MyAuthenticationProvider();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception{
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    JwtTokenUtil jwtTokenUtil(){
        return new JwtTokenUtil();
    }
    //自己定义一个manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        // 调用自己定义的provider
        auth.authenticationProvider(myAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
             .and()
                .formLogin()
                    .loginPage("/index.html").permitAll()
                    .loginProcessingUrl("/loginProcess")   //自定义的一个登陆验证地址，controller中没有对应的方法，只是为了login过滤
                    .usernameParameter("loginName")
                    .passwordParameter("password")
                    .successForwardUrl("/login/success")    //这里要注意一点这个loginSuccess必须是POST方法  当然你也可以自己定义一个successhandler
                    .failureForwardUrl("/login/failure")
             .and()
                .logout()
                    .logoutUrl("/logout")
                    .permitAll()
             .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
                //使用的是JWT，我们这里不需要csrf
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http
                .headers().cacheControl();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //因为boot 默认的静态资源位置就是在resource/static目录下面 ,这里我做一个测试
        web.ignoring().antMatchers("/**/*.html",
                                                "/user/register",
                                                "/login/getToken",
                                                "/**/*.ico",
                                                "/**/*.jpg",
                                                "/**/*.js",
                                                "/**/*.png",
                                                "/**/*.css"
        );
    }
}
