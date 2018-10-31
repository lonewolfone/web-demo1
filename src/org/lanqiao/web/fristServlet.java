package org.lanqiao.web;

import javax.servlet.*;
import java.io.IOException;

public class fristServlet implements Servlet {

    @Override
    //初始化:相当于构造方法，用来创建对象
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
        String paramValue =servletConfig.getInitParameter("java");
        System.out.println(paramValue);
    }

    @Override
    //servlet配置信息
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    @Override
    //服务
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
