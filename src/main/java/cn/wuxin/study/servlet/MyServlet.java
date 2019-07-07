package cn.wuxin.study.servlet;

import cn.wuxin.study.servlet.abs.Servlet;
import cn.wuxin.study.request.HttpServletRequest;
import cn.wuxin.study.response.HttpServletResponse;

/**
 * @program: mdemo
 * @description: 自定义Servlet
 * @author: Xin Wu
 * @create: 2019-07-07 19:57
 **/
public class MyServlet extends Servlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.write("<h1>真开心！！！！</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
