package cn.wuxin.study.request;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @program: mdemo
 * @description: 自定义Request对象，对发送来的请求进行解析
 * @author: Xin Wu
 * @create: 2019-07-07 17:17
 **/
public class HttpServletRequest {
    private String url ;
    private String method ;
    private InputStream inputStream ;
    public HttpServletRequest(InputStream inputStream) {
        this.inputStream = inputStream;
        try {
            parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public void parse() throws IOException {
        int count = 0 ;
        while (count == 0){
            count = inputStream.available();
        }
        byte []data = new byte[count] ;
        inputStream.read(data);
        String str = new String(data) ;
        //请求的第一行
        String split = str.split("\\n")[0];
        //对第一行进行进一步的拆分
        String[] strings = split.split("\\s");
        //取第一个为method
        this.method = strings[0] ;
        //取第二个为url地址
        this.url = strings[1].replace("/","") ;
    }
}
