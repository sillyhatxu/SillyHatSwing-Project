package com.sillyhat.learningenglish.utils;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "classpath:applicationContext-config.xml",
                "classpath:applicationContext-database.xml",
        })
public class JunitTestSupport extends AbstractJUnit4SpringContextTests {

}
