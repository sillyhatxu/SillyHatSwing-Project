package com.sillyhat.learningenglish.business.system.mapper;

import com.sillyhat.learningenglish.business.system.dto.UserDTO;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.swing.dto.PageDTO;

import java.util.List;

/**
 * WordRepositoryService
 *
 * @author 徐士宽
 * @date 2017/3/13 11:46
 */
public interface UserMapper {

    public UserDTO getUserById(String id);

}
