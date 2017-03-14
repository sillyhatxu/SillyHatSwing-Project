package com.sillyhat.load;

import com.sillyhat.learningenglish.utils.JunitTestSupport;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoadTest
 *
 * @author 徐士宽
 * @date 2017/3/13 10:44
 */
public class LoadTest extends JunitTestSupport {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testLogger() {
        logger.error("error");
        logger.debug("debug");
        logger.info("info");
        System.out.println("-------------");
    }

    @Test
    public void testSpringMybatis() {
        logger.error("error");
        logger.debug("debug");
        logger.info("info");
        System.out.println("-------------");
    }
}
