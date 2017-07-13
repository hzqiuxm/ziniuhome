package com.ziniu.controller.commons;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * 使用注解标注过滤器
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/21 0021 21:56
 */
@WebFilter(filterName="myFilter",urlPatterns="/*")
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("执行过滤操作");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

        System.out.println("过滤器销毁");
    }
}
