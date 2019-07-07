package cn.wuxin.study.dispather;

import cn.wuxin.study.servlet.abs.Servlet;
import cn.wuxin.study.request.HttpServletRequest;
import cn.wuxin.study.response.HttpServletResponse;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * @program: mdemo
 * @description: 发送来的请求进行处理
 * @author: Xin Wu
 * @create: 2019-07-07 17:40
 **/
public class Dispatcher {
    private HttpServletRequest request ;
    private HttpServletResponse response ;

    //保存servlet对应的key=位置，value=映射路径
    private Map<String,String> servletClass ;

    //用来保存Servlet,key = 映射路径，value=class对象
    private ConcurrentMap<String , Class<Servlet>> servletMap  ;

    public Dispatcher(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 对请求进行分发处理
     * 可以分发动态Servlet
     * 和静态html，css，image等
     */
    public void dispatcher(){
        try {
            String url = request.getUrl() ;
            if (!response.writeHtml(url)) { //如果没有静态页面,进行初始化
                try {
                    if (this.servletClass.get("/"+url)!=null){ //请求路径有对应的Servlet
                        initServlet("/"+url); //进行Servlet初始化
                        Servlet servlet = this.servletMap.get("/" + url).getDeclaredConstructor().newInstance();
                        servlet.service(request,response);
                    }else {
                        response.out404();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 进行Servlet初始化加载
     */
   private void initServlet(String path)throws Exception{
        if (this.servletClass!=null){
            if (this.servletMap == null)
                this.servletMap = new ConcurrentHashMap<>() ;
            this.servletMap.put(path,(Class<Servlet>)Class.forName(this.servletClass.get(path))) ;
        }
   }

    /**
     * 外部设置的Servlet映射路径和位置。
     * @param servletClass
     */
    public void setServletClass(Map<String, String> servletClass) {
        this.servletClass = servletClass;
    }
}
