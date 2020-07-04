package com.wanghanbing.learn;

import com.wanghanbing.learn.dao.bo.MainBo;
import com.wanghanbing.learn.mapper.MainMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TableDaoImplTest {

    @Test
    public void update() {
        System.out.println("start-------------------------");
        //初始化容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        //获得bean
        MainMapper mainMapper = ctx.getBean(MainMapper.class);
        //访问数据库
        MainBo mainBo = new MainBo();
        mainBo.setName("wanghanbing");
        mainBo.setOldStatus("01");
        mainBo.setNewStatus("02");
        int result = mainMapper.updateStatusByName(mainBo);
        System.out.println("end----------------------------=" + result);
    }
}