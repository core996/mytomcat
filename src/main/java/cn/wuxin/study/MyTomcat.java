package cn.wuxin.study;

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
    private int port = 8080 ;
    public MyTomcat() {
    }
    public MyTomcat(int port) {
        this.port = port;
    }
    public void start(){
        try {
            ServerSocket socket = new ServerSocket(this.port);
            while(true){
                Socket accept = socket.accept();
                InputStream inputStream = accept.getInputStream();
                OutputStream outputStream = accept.getOutputStream();
                int count = 0 ;
                while (count == 0){
                    count = inputStream.available();
                }
                byte []data = new byte[inputStream.available()] ;
                inputStream.read(data);
                System.out.println(new String(data));
                outputStream.write("123".getBytes());
                accept.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
