package com.sillyhat.learningenglish.business.wordrepository.mapper;

import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.swing.dto.PageDTO;

import java.util.List;

/**
 * WordRepositoryService
 *
 * @author 徐士宽
 * @date 2017/3/13 11:46
 */
public interface WordRepository {

    public List<WordRepositoryDTO> queryWordRepositoryByPage(PageDTO page);

    public int queryWordRepositoryCountByPage(PageDTO page);

}
