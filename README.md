# 手工实现基础tomcat。

### 第一次造轮子~
* * *
* 可以对静态资源和Servlet进行访问。  
* 根据Tomcat，第一次访问Servlet的时候才会进行初始化。  
* 运用了一个Dispatcher程序类对请求进行分发处理。  
* 用CurrentHashMap保存 Servlet。  

