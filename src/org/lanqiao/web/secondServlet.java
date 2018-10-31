package org.lanqiao.web;

import javax.servlet.*;
import java.io.IOException;

public class secondServlet implements Servlet {
    @Override
    //初始化Servlet:相当于构造方法，用来创建对象
    //参数：通过ServletConfig对象，即可拿到Servlet的配置信息
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init....................");
    }

    @Override
    //获取ServletConfig对象，相当于get()方法
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    //处理请求
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service.........................");
    }

    @Override
    //获取Servlet信息
    public String getServletInfo() {
        return null;
    }

    @Override
    //完成扫尾工作，Servlet生命结束
    public void destroy() {

    }
}
