package com.wanghanbing;

import com.wanghanbing.learn.ExtendMapperConvert;
import com.wanghanbing.learn.MapperConvert;
import com.wanghanbing.learn.model.Student;
import com.wanghanbing.learn.model.Teach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml" })
public class MapperConvertTest {

    @Resource
    private ExtendMapperConvert extendMapperConvert;

    @Test
    public void test_convert() {
        Student student = new Student(null,  null);
        Teach teach = new Teach();
        teach.setName("iiiiii");

        extendMapperConvert.convert(student, teach);

        System.out.println(teach.getId() + "," + teach.getName());

    }

}