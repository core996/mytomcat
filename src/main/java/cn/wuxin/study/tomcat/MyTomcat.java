package cn.wuxin.study.tomcat;

import cn.wuxin.study.request.HttpServletRequest;
import cn.wuxin.study.response.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
                InputStream inputStream = accept.getInputStream();
                OutputStream outputStream = accept.getOutputStream();
                HttpServletRequest request = new HttpServletRequest(inputStream) ;
                HttpServletResponse response = new HttpServletResponse(outputStream) ;
                if (!response.writeHtml(request.getUrl())) {
                    response.out404();
                }
                accept.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
