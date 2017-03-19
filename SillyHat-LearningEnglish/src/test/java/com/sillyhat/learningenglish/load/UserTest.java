package com.sillyhat.learningenglish.load;

import com.sillyhat.learningenglish.business.learningplan.service.LearningPlanService;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserLearningPlanDTO;
import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.Constants;
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
public class UserTest extends JunitTestSupport {

    private final Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private UserService userService;

    @Autowired
    private WordRepositoryService wordRepositoryService;

    @Autowired
    private LearningPlanService learningPlanService;

    @Test
    public void testCheckUser() {
        System.out.println(userService.checkUser("administrator","123456"));
        System.out.println(userService.checkUser("xushikuan","123456"));
    }
    @Test
    public void testAddUser() {
        UserDTO dto = new UserDTO();
        dto.setLogin("xushikuan");
        dto.setPassword("123");
        dto.setUserName("徐士宽");
        dto.setIsDelete(0);
        dto.setIsAdministrators(1);
        userService.saveUse(dto);
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
        userService.saveUse(dto);
    }

    @Test
    public void testQueryAllUser() {
        List<UserDTO> list = userService.queryAllUser();
        for(UserDTO dto : list){
            System.out.println("++++++++++++++++++++++++++++++++");
            System.out.println(dto.toString());
            System.out.println("++++++++++++++++++++++++++++++++");
        }
    }

    /**
     * 词典数据全部copy到用户学习计划表
     */
    @Test
    public void testCopyUserPlan() {
        long userId = 2l;
        UserDTO user = userService.getUserById(userId);
        List<WordRepositoryDTO> wordRepositoryDTOList = wordRepositoryService.queryWordRepositoryAll();
        List<UserLearningPlanDTO> userLearningPlanDTOList = learningPlanService.queryUserLearningPlanByUserId(userId);
        for (WordRepositoryDTO wordRepository : wordRepositoryDTOList) {
            boolean insert = true;
            UserLearningPlanDTO  dto = new UserLearningPlanDTO();
            for (UserLearningPlanDTO userLearningPlan : userLearningPlanDTOList){
                if(userLearningPlan.getWordId() == wordRepository.getId()){
                    //已经存在
                    insert = false;
                    break;
                }
            }
            if(insert){
                dto.setUserId(userId);
                dto.setWordId(wordRepository.getId());
                dto.setIsLearning(Constants.DEFAULT_IS_LEARNING);
                dto.setReviewFrequency(Constants.DEFAULT_REVIEW_FREQUENCY);
                dto.setErrorFrequency(Constants.DEFAULT_ERROR_FREQUENCY);
                dto.setSuccessFrequency(Constants.DEFAULT_SUCCESS_FREQUENCY);
                dto.setCreatedUser(userId);
                dto.setUpdatedUser(userId);
                learningPlanService.addUserLearningPlan(dto);
            }
        }

    }
    @Test
    public void testQueryUserPlan() {
        long userId = 2l;
        List<UserLearningPlanDTO> userLearningPlanDTOList = learningPlanService.queryUserLearningPlanByUserId(userId);
        System.out.println(userLearningPlanDTOList.size());
        for (UserLearningPlanDTO userLearningPlan : userLearningPlanDTOList){
            System.out.println(userLearningPlan.toString());
        }
    }

}
