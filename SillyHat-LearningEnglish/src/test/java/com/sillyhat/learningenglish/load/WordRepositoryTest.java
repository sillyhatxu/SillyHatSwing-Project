package com.sillyhat.learningenglish.load;

import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.JunitTestSupport;
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
public class WordRepositoryTest extends JunitTestSupport {

    private final Logger logger = LoggerFactory.getLogger(WordRepositoryTest.class);

    @Autowired
    private WordRepositoryService wordRepositoryService;

    @Test
    public void testAddUser() {
        UserDTO dto = new UserDTO();
        dto.setLogin("xushikuan");
        dto.setPassword("123");
        dto.setUserName("徐士宽");
        dto.setIsDelete(0);
        dto.setIsAdministrators(1);
    }
    @Test
    public void testUpdateUser() {
        UserDTO dto = new UserDTO();
//        dto.setId("40288AF15AE21F5B015AE21F5B440000");
        dto.setLogin("xushikuan");
        dto.setPassword("123");
        dto.setUserName("徐士宽");
        dto.setIsDelete(0);
        dto.setIsAdministrators(1);
    }
    @Test
    public void testQueryAllUser() {
        List<WordRepositoryDTO> list = wordRepositoryService.queryWordRepositoryAll();
        for(WordRepositoryDTO dto : list){
            System.out.println("++++++++++++++++++++++++++++++++");
            System.out.println(dto.toString());
            System.out.println("++++++++++++++++++++++++++++++++");
        }
    }

}
