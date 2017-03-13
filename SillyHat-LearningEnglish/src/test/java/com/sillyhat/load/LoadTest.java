package com.sillyhat.load;

import com.sillyhat.business.main.service.SystemService;
import com.sillyhat.business.question.dto.WordQuestionDTO;
import com.sillyhat.business.question.service.QuestionService;
import com.sillyhat.utils.JunitTestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * LoadTest
 *
 * @author 徐士宽
 * @date 2017/3/13 10:44
 */
public class LoadTest extends JunitTestSupport {

    private final Logger logger = LoggerFactory.getLogger(LoadTest.class);

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SystemService systemService;

    @Test
    public void testLogger() {
        logger.error("-------------error-------------");
        logger.debug("-------------debug-------------");
        logger.info("-------------info-------------");
        System.out.println("-------------");
    }

    @Test
    public void testSpringMybatis() {
        logger.info("--------------------------------");
        List<WordQuestionDTO> list = questionService.queryAllWordQuestion();
        for(WordQuestionDTO dto : list){
            logger.info(dto.toString());
            logger.info(dto.toString().replaceAll("\n\r","\\n"));
            logger.info(dto.toString().replaceAll("\\n","\n\r"));
        }
        logger.info("--------------------------------");
    }

    @Test
    public void testInitSystemTable() {
        logger.info("--------------------------------");
        systemService.initSystemTable();
        logger.info("--------------------------------");
    }


}
