package com.sillyhat.learningenglish.business.wordrepository.service.impl;

import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.mapper.WordRepositoryMapper;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.swing.dto.PageDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * QuestionServiceImpl
 *
 * @author 徐士宽
 * @date 2017/3/13 11:46
 */
@Service
public class WordRepositoryServiceImpl implements WordRepositoryService {

    @Resource
    private WordRepositoryMapper wordRepositoryMapper;

    @Override
    public List<WordRepositoryDTO> queryWordRepositoryByPage(PageDTO page) {
        return wordRepositoryMapper.queryWordRepositoryByPage(page);
    }

    @Override
    public int queryWordRepositoryTotalCountByPage(PageDTO page) {
        return wordRepositoryMapper.queryWordRepositoryTotalCountByPage(page);
    }

    @Override
    public WordRepositoryDTO getWordRepositoryById(String id) {
        return wordRepositoryMapper.getWordRepositoryById(id);
    }
}
