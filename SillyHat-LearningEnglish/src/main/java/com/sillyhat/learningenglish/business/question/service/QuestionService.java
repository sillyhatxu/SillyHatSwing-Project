package com.sillyhat.learningenglish.business.question.service;

import com.sillyhat.learningenglish.business.question.dto.WordQuestionDTO;

import java.util.List;

/**
 * QuestionService
 *
 * @author 徐士宽
 * @date 2017/3/13 11:26
 */
public interface QuestionService {

    public List<WordQuestionDTO> queryAllWordQuestion();

}
