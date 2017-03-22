package com.sillyhat.learningenglish.load;

import com.sillyhat.learningenglish.business.message.dto.YouDaoDTO;
import com.sillyhat.learningenglish.business.message.dto.YouDaoWebDTO;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.HttpUtils;
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

    @Test
    public void testQueryAllWord() {
        StringBuffer words = new StringBuffer();
        List<WordRepositoryDTO> list = wordRepositoryService.queryWordRepositoryAll();
        for(WordRepositoryDTO dto : list){
            words.append(dto.getWord()).append(",");
        }
        System.out.println(words.toString());
    }

    @Test
    public void testInitWord() {
//        String wordSrc = "private,privacy,modify,model,mode,modern,moderate,modest,alert,alternative,significant";
//        String wordSrc = "private,privacy,modify,model,mode,modern,moderate,modest,alert,alternative,significant,significance,extreme,extremely,tremendous,comment,outstanding,excellent,splendid,formal,glance ,grace,graceful,elegant,elegance,grateful,magnificent,official,officer,sacrifice,appealing,ball,race,racial,discrimination,global,globe,glory,glorious,glare,flag,flame,fly,flexible,flexibility,reflect,reflection,conflict,appeal,alcohol,sympathetic,pathetic,miserable,symbol,meter,system,systematic,flood,float,fluent,criticize,criticism,critic,classical,symptom,sympathetically,flu,influence,influential,classic";
        String wordSrc = "critic,classical,symptom,sympathetically,flu,influence,influential,classic";
        String [] words = wordSrc.split(",");
        String url = "http://fanyi.youdao.com/openapi.do";
        String params = "keyfrom=SillyHatYouDao&key=987724779&type=data&doctype=json&version=1.1&q=";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            YouDaoDTO youdao = HttpUtils.requestHttpGetToYouDao(url,params + word);
            WordRepositoryDTO dto = new WordRepositoryDTO();
            dto.setWord(word);
            dto.setUsPhonetic("[" + youdao.getBasic().getUsPhonetic() + "]");
            dto.setUkPhonetic("[" + youdao.getBasic().getUkPhonetic() + "]");
            List<String> wordTranslateList = youdao.getBasic().getExplains();
            String wordTranslate = "";
            for (int j = 0; j < wordTranslateList.size(); j++) {
                wordTranslate += wordTranslateList.get(j) + "\r\n";
            }
            dto.setWordTranslate(wordTranslate);

            String webTranslate = "";
            List<YouDaoWebDTO> youdaoWebList = youdao.getWeb();
            for (int j = 0; j < youdaoWebList.size(); j++) {
                YouDaoWebDTO youDaoWebDTO = youdaoWebList.get(j);
                webTranslate += youDaoWebDTO.getKey() + "  ";
                List<String> values = youDaoWebDTO.getValue();
                for (int k = 0; k < values.size(); k++) {
                    webTranslate += values.get(k) + ";  ";
                }
                webTranslate += "\r\n";
            }
            dto.setWebTranslate(webTranslate);
            dto.setCreatedUser(1l);
            dto.setUpdatedUser(1l);
            wordRepositoryService.addWordRepository(dto);
//            private String word;
//            private String usPhonetic;
//            private String ukPhonetic;
//            private String wordTranslate;
//            private String webTranslate;
//            private String sampleSentences;
        }

    }


}
