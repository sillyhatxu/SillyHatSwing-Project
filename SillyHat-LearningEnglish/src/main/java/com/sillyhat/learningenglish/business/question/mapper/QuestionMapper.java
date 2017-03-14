package com.sillyhat.learningenglish.business.question.mapper;

import com.sillyhat.learningenglish.business.question.dto.WordQuestionDTO;
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
