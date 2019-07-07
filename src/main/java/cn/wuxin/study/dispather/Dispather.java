package cn.wuxin.study.dispather;

import cn.wuxin.study.request.HttpServletRequest;


/**
 * @program: mdemo
 * @description: 发送来的请求进行处理
 * @author: Xin Wu
 * @create: 2019-07-07 17:40
 **/
public class Dispather {
    public void dispatcher(HttpServletRequest request){
        if (request.getMethod().equalsIgnoreCase("get")){
            if(!doHtml(request.getUrl())){
                if(!doServlet(request.getUrl())){

                }
            }
        }
    }
    public boolean doHtml(String url){
        return false ;
    }
    public boolean doServlet(String url){
        return false ;
    }
}
