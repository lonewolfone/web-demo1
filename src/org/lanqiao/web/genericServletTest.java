package org.lanqiao.web;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "genericServletTest",urlPatterns ={"/genericServletTest","/demo4"},initParams = {@WebInitParam(name ="username",value = "火女")})
//@WebServlet("/word")
    public class genericServletTest extends GenericServlet {
         @Override
         public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            System.out.println("注解配置");
            ServletConfig servletConfig = this.getServletConfig();
            String userValue = servletConfig.getInitParameter("username");
            System.out.println(userValue);
        }
}
