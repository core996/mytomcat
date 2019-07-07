package cn.mytomcat.test;

import cn.wuxin.study.tomcat.MyTomcat;
import org.junit.Test;

/**
 * @program: mdemo
 * @description: 进行自己实现的Tomcat测试
 * @author: Xin Wu
 * @create: 2019-07-07 16:22
 **/
public class TomcatTest {
    @Test
    public void test(){
        new MyTomcat().start();
    }
}
