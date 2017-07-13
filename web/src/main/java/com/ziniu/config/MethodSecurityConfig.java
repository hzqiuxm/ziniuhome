package com.ziniu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/19 0019 10:35
 */
@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true,prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {


}
