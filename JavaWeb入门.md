## Web的学习

### 1、创建一个web项目

### 概述：

#### Web应用

​	请求访问Web程序，基于BS架构，所有程序访问基于浏览器访问

![ ](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\105.png)

### 创建项目：

![ ](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\104.png)

#### 在web.xml中配置

```x&#39;m
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <!--设置启动页-->
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
</web-app>
```

### 2、HTTP协议 

​	浏览器 访问  后端服务程序 ，需通过网络通信，遵循：HTTP协议

#### HTTP概述

如图：

![ ](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\106.png)

------

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\107.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\108.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\109.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\110.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\111.png)

------

####请求协议

cookie：将用户请求信息保存到本地。

淘宝：浏览器将用户信息保存到cookie中

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\112.png)

------

####响应协议

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\114.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\113.png)

####状态行中的状态码

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\115.png)

####请求方式

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\116.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\117.png)

### 3、Servlet

####Servlet简介

a.访问请求需要Servlet容器，如：Tomcat容器

b.访问请求时，通过：请求地址 + 端口号，请求到Tomcat容器，再请求到Servlet,Servlet再去请求其他应用程序。

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\118.png)

------

![ ](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\119.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\120.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\121.png)

#### Servlet初探

##### 创建Servlet

######a.实现Servlet接口，并实现其中的方法
​        init
​        service
​        destroy
​        getServletConfig
​        getServletInfo

 **Servlet写好之后，需告诉Web容器，执行哪个Servlet,如何请求？需再web.xml中进行注册和配置**

######b.在web.xml文件中进行servlet的注册和配置

```xml
 <servlet>
 		<!-- 请求的url地址-->
 		<!--servlet名称 一般和serlvet保持一直-->
        <servlet-name>firstServlet</servlet-name>
        <!--servlet对应的类  需要全类名-->
        <servlet-class>org.lanqiao.web.FirstServlet</servlet-class>
    </servlet>
	<!--创建servlet映射-->
    <servlet-mapping> 
    	<!--servlet名称 需要和上边你的名称保持一致-->
        <servlet-name>firstServlet</servlet-name>
        <!-- 请求的url地址-->
        <url-pattern>/</url-pattern> 
    </servlet-mapping>
```

###### c.执行情况：

​                init  只执行一次  实现对servlet的初始化
​                service 没请求一次 均会执行一次 处理请求的方法
​                destroy  当该servlet从servlet容器中卸载的时候 执行   执行一些扫尾工作
​                getServletConfig
​                getServletInfo

###### d.请求过程:

​        当通过浏览器去访问localhost:8080   tomcat会首先解析web.xml

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\122.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\123.png)

------



####Servlet生命周期

当调用servlet的init方法的时候 就是初始化了一个servlet对象    servlet 对象在整个生命周期中只有一个对象  所以servlet是单例模式
​          什么时候创建servlet的实例对象 与<load-on-startup>1</load-on-startup>
​          消亡：当serlvet从容器中卸载的时候 则宣告servlet生命结束

​	        init  完成servlet的初始化
​                service 处理请求
​                destroy 处理一些扫尾工作               

####Servlet配置

```xml
<!--配置servlet的初始化参数-->
                <init-param>
                    <!--参数名称-->
                    <param-name>hello</param-name>
                    <!--参数值-->
                    <param-value>world</param-value>
                </init-param>
                <!--该配置项 指定了servlet的初始化的时机  如果是负数   那么则在第一次请求的时候 才进行servlet的初始化   如果为正数，则是在servlet容器启动的时候就初始化了  正数越小   初始化的时机越早-->
                <load-on-startup>1</load-on-startup>
```

####Servlet3.0新特性

使用注解开发servlet，就无需进行web.xml的配置
@webServlet
​    name
​    urlpartterns
现在主流的开发模式  约定大于配置
在开发中要么使用xml进行配置  要么使用注解
如果在注解中只有url 则可以直接写 而不需要其他信息 包括url的名称

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\125.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\126.png)

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\127.png)

### 4、url-pattern的配置：

```xml
 <url-pattern>/</url-pattern> /代标项目的根路径
          <url-pattern>/abc/aaa/bbb/servletDemo</url-pattern>多层路径配置 可以很好的区分不同的请求
          前边两种都不常用
          通常情况下  我们采用通配符进行配置  *
           <url-pattern>/</url-pattern> 知道
            <url-pattern>.do</url-pattern>
            <url-pattern>.action</url-pattern>
          注意：在一个url-pattern中只能出现一个通配符（）
           /*/*    *.*
```

### 5、Servlet实现方式:实现Servlet接口

​	思考：如何在实现Servlet接口时只实现service（）方法，其他方法由其内部实现，从而减少代码冗余的问题。

​      Why要实现Servlet接口中的方法，因为Servlet接口中的方法是抽象的。
​      How to do:service()让用户实现，程序员去实现其他四种方法，即让service()方法依然保持抽象本质，而其他四种方法变为具体方法。
​      既包含抽象方法又包含具体方法的类是抽象类。自行定义一个抽象类实现servlet接口，去实现其中的四种方法，而将service()定义为抽象的，让用户去实现。

a.自定义一个抽象类

```java
public abstract class MyServlet implements Servlet {
    private ServletConfig servletConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse);

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}

```

b.实现类：MyServletImplTest

```java
public class MyServletImplTest extends MyServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
       ServletConfig servletConfig = this.getServletConfig();
        String paramValue = servletConfig.getInitParameter("username");
        System.out.println(paramValue);
        String displayname = servletConfig.getServletName();
        System.out.println(displayname);
    }
}
```

c.配置信息

```xml
 <servlet>
        <display-name>MyServletImplTest</display-name>
        <servlet-name>MyServletImplTest</servlet-name>
        <servlet-class>org.lanqiao.web.MyServletImplTest</servlet-class>
        <init-param>
            <param-name>username</param-name>
            <param-value>宙斯</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>MyServletImplTest</servlet-name>
        <url-pattern>/ss</url-pattern>
    </servlet-mapping>
```

### 6、servletRequest 和servletResponse 封装

ServletRequest servletRequest  封装了请求信息  包括请求头和请求体
ServletResponse servletResponse 封装了响应信息  包括响应头和响应体

请求访问携带参数：在url之后，如：http://localhost:8080/ss?a=1&b=2

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\124.png)

MyServletImplTest类：

```java
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
```

### 7、Servlet实现方式:继承GenericServlet接口

genericServletTest类

```java
@WebServlet(name = "genericServletTest",urlPatterns ={"/genericServletTest","/demo4"})
public class genericServletTest extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("注解配置");
    }
}
```

**使用注解开发servlet，就无需进行web.xml的配置**
@webServlet
​    name
​    urlpartterns

### 8、继承HttpServlet

**HttpServlet类中只有两个方法：doget() 、dopost()方法**

![ ](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\128.png)

HttpServlet是对Http协议提供了特殊支持的servlet的实现
在http协议中，规定的请求方式有四种 （get  post  put  delete），在现阶段  所有的浏览器只支持两种方式：get  post

**继承HttpServlet将是我们最常用的**,因目前浏览器使用的协议即是HTTP协议

```java
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
```

### 9、当当