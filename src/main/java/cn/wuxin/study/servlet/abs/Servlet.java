package cn.wuxin.study.servlet.abs;

import cn.wuxin.study.request.HttpServletRequest;
import cn.wuxin.study.response.HttpServletResponse;

/**
 * @program: mdemo
 * @description: 创建服务端处理程序类
 * @author: Xin Wu
 * @create: 2019-07-07 17:50
 **/
public abstract class Servlet {
    public void service(HttpServletRequest request , HttpServletResponse response) {
        String method = request.getMethod() ;
        if (method.equalsIgnoreCase("get")){
            this.doGet( request ,  response);
        }else if(method.equalsIgnoreCase("post")){
            this.doPost(request , response);
        }
    }
    protected abstract void  doGet(HttpServletRequest request, HttpServletResponse response)  ;
    protected abstract void doPost(HttpServletRequest request , HttpServletResponse response) ;
}
