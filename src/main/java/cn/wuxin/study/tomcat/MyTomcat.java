package cn.wuxin.study.tomcat;

import cn.wuxin.study.dispather.Dispatcher;
import cn.wuxin.study.request.HttpServletRequest;
import cn.wuxin.study.response.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @description: 创建Tomcat主体类
 * @author: Xin Wu
 * @create: 2019-07-07 16:12
 **/
public class MyTomcat {
    //端口定义
    private int port = 8080 ;
    public MyTomcat() {
    }
    public MyTomcat(int port) {
        this.port = port;
    }
    public void start(){
        try {
            //创建bio客户端
            ServerSocket socket = new ServerSocket(this.port);
            while(true){
                //进行连接监听，等待连接
                Socket accept = socket.accept();
                //获取输入流
                InputStream inputStream = accept.getInputStream();
                //获取输入流
                OutputStream outputStream = accept.getOutputStream();
                //进行Request对象实例化
                HttpServletRequest request = new HttpServletRequest(inputStream) ;
                //进行Response对象实例化
                HttpServletResponse response = new HttpServletResponse(outputStream) ;
                //创建分发程序类
                Dispatcher dispather = new Dispatcher(request, response);
                //进行Servlet配置
                Map<String , String> map = new HashMap<>() ;
                map.put("/hello.servlet","cn.wuxin.study.servlet.MyServlet");
                dispather.setServletClass(map);
                //调用分发处理程序
                dispather.dispatcher();
                //关闭连接
                accept.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
