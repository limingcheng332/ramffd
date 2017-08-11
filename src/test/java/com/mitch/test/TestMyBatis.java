package com.mitch.test;

import com.mitch.bean.Yilou;
import com.mitch.service.YilouService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
      private ApplicationContext ac = null;
    @Resource
    private YilouService yilouService;
    public YilouService getYilouService() {
        return yilouService;
    }

    public void setYilouService(YilouService yilouService) {
        this.yilouService = yilouService;
    }

  @Before
  public void before() {
      ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
//      userService = (IUserService) ac.getBean("userService");
  }

    @org.junit.Test
    public void test1() {
        List<Yilou> list = yilouService.getYilouList();
         System.out.println(list);
        // logger.info("值："+user.getUserName());
    }


}
