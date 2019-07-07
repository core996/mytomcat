package cn.wuxin.study.Servlet;

import cn.wuxin.study.request.HttpServletRequest;
import cn.wuxin.study.response.HttpServletResponse;

/**
 * @program: mdemo
 * @description: 创建服务端处理程序类
 * @author: Xin Wu
 * @create: 2019-07-07 17:50
 **/
public abstract class Servlet {
    protected void service(HttpServletRequest request , HttpServletResponse response) {
        String method = request.getMethod() ;
        if (method.equalsIgnoreCase("get")){

        }else if(method.equalsIgnoreCase("post")){

        }else {

        }
    }
    abstract void  doGet(HttpServletRequest request , HttpServletResponse response)  ;
    abstract void doPost(HttpServletRequest request , HttpServletResponse response) ;
}
