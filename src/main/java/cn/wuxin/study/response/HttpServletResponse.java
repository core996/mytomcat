package cn.wuxin.study.response;

import java.io.*;

/**
 * @program: mdemo
 * @description: 对回应进行处理
 * @author: Xin Wu
 * @create: 2019-07-07 17:41
 **/
public class HttpServletResponse {
    private OutputStream outputStream  ;
    public HttpServletResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    /**
     * 对静态HTML页面进行输出
      * @param pageUrl
     * @return 输出成功返回true 否则返回false
     * @throws IOException
     */
    public boolean writeHtml(String pageUrl) throws IOException{
        //取得请求路径对应的服务器端静态资源
        InputStream fileInputStream =
                HttpServletResponse.class.getClassLoader().getResourceAsStream(
                        pageUrl);
        //如果取得了就进行输出
        if (fileInputStream!=null) {
            StringBuffer stringBuffer=new StringBuffer();
            byte data[] = new byte[1024];
            int len ;
            while ((len = fileInputStream.read(data)) != -1) {
                stringBuffer.append(new String(data,0,len));
            }
            //设置回应的头信息
            String responseHead="HTTP/1.1 200 OK\r\nContent-Type: text/html;charset=gbk\r\nContent-Length: "+stringBuffer.toString().getBytes().length+"\r\n\r\n";
            //进行输出
            out(responseHead,stringBuffer.toString());
            return true ;
        }
        return false;
    }

    /**
     * 错误信息页面跳转
     */
    public void out404() {
        String responseBody="<h1>404-找不到页面</h1>";
        String responseHead="HTTP/1.1 404 Not Found\r\nContent-Type: text/html;charset=utf-8\r\nContent=Length: "
                +responseBody.getBytes().length+"\r\n\r\n";
        try{
            out(responseHead,responseBody);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 进行输出
     * @param responseHead 头信息
     * @param responseBody 主体
     * @throws IOException
     */
    private void out(String responseHead,String responseBody) throws IOException {
        outputStream.write(responseHead.getBytes());
        outputStream.write(responseBody.getBytes());
        outputStream.flush();
    }
}
