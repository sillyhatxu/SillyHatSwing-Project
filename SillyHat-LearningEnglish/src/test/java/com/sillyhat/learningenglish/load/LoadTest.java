package com.sillyhat.learningenglish.load;

import com.sillyhat.learningenglish.business.main.service.SystemService;
import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.JunitTestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.List;
import java.util.Locale;

/**
 * LoadTest
 *
 * @author 徐士宽
 * @date 2017/3/13 10:44
 */
public class LoadTest extends JunitTestSupport {

    private final Logger logger = LoggerFactory.getLogger(LoadTest.class);

    @Autowired
    private WordRepositoryService questionService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MessageService messageService;

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
        List<WordRepositoryDTO> list = questionService.queryWordRepositoryByPage(null);
        for(WordRepositoryDTO dto : list){
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

    @Test
    public void testMessage() {
        logger.info("--------------------------------");
        logger.info(messageSource.getMessage("menu.word.repository", null, "message.not.configured",  new Locale("zh")));
        logger.info(messageSource.getMessage("menu.word.repository", null, "message.not.configured",  new Locale("en")));
        logger.info(messageSource.getMessage("menu.word.repositoryhehe", null, "message.not.configured",  new Locale("zh")));
        logger.info(messageSource.getMessage("menu.word.repositoryhehe", null, "message.not.configured",  new Locale("en")));
        logger.info(messageService.getMessageZH("menu.word.repository"));
        logger.info(messageService.getMessageEN("menu.word.repository"));
        logger.info("--------------------------------");
    }
}
