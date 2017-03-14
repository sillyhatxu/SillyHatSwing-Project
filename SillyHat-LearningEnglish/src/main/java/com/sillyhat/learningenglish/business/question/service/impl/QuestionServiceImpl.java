package com.sillyhat.learningenglish.business.question.service.impl;

import com.sillyhat.learningenglish.business.question.dto.WordQuestionDTO;
import com.sillyhat.learningenglish.business.question.mapper.QuestionMapper;
import com.sillyhat.learningenglish.business.question.service.QuestionService;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;

/**
 * QuestionServiceImpl
 *
 * @author 徐士宽
 * @date 2017/3/13 11:46
 */
@Service
public class QuestionServiceImpl implements QuestionService{

    @Resource
    private QuestionMapper questionMapper;

    public List<WordQuestionDTO> queryAllWordQuestion() {
        return questionMapper.queryAllWordQuestion();
    }
}
