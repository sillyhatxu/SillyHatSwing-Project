package com.sillyhat.learningenglish.business.wordrepository.service.impl;

import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.mapper.WordRepository;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.swing.dto.PageDTO;

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
public class WordRepositoryServiceImpl implements WordRepositoryService {

    @Resource
    private WordRepository wordRepository;

    @Override
    public List<WordRepositoryDTO> queryWordRepositoryByPage(PageDTO page) {
        return wordRepository.queryWordRepositoryByPage(page);
    }
}
