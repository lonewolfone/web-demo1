package org.lanqiao.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServletImplTest extends MyServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
        ServletConfig servletConfig = this.getServletConfig();
        String paramValue = servletConfig.getInitParameter("username");
        System.out.println(paramValue);
        String displayname = servletConfig.getServletName();
        System.out.println(displayname);
        // ..............servletRequest.................................................
        String aValue = servletRequest.getParameter("a");
        String bValue = servletRequest.getParameter("b");
        System.out.println("aValue:" + aValue +"  "+"bValue:"+bValue );
        String encoding =servletRequest.getCharacterEncoding();
        String contentType = servletRequest.getContentType();
        System.out.println("encoding:"+ encoding + "  "+ "contentType:"+contentType);
        //..................servletResponse..................................................
        String encoding1 =   servletRequest.getCharacterEncoding();
        System.out.println("encoding="+encoding1 );
        String type=  servletRequest.getContentType();
        System.out.println("type="+type );

        PrintWriter wirter = null;
        try {
            wirter = servletResponse.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        wirter.write("<html>");
        wirter.write("<head>");
        wirter.write("<title>hello world</title>");
        wirter.write("</head>");
        wirter.write("<body>");
        wirter.write("<title>hello world</title>");
        wirter.write("<h1>hello world</h1>");
        wirter.write("</body>");
        wirter.write("</html>");
    }
}
