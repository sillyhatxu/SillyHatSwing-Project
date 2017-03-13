package com.sillyhat.business.question.mapper;

import com.sillyhat.business.question.dto.WordQuestionDTO;

import java.util.List;

/**
 * QuestionMapper
 *
 * @author 徐士宽
 * @date 2017/3/13 11:46
 */
public interface QuestionMapper {

    public List<WordQuestionDTO> queryAllWordQuestion();

}
