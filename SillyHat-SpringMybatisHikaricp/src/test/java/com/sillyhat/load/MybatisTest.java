package com.sillyhat.load;

import com.sillyhat.utils.JunitTestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MybatisTest
 *
 * @author 徐士宽
 * @date 2017/3/13 10:43
 */
public class MybatisTest extends JunitTestSupport {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testLogger() {
        logger.error("error");
        logger.debug("debug");
        logger.info("info");
    }
}
