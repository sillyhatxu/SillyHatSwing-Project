package com.sillyhat.learningenglish.business.system.mapper;

import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserLearningParamsDTO;

import java.util.List;

/**
 * WordRepositoryService
 *
 * @author 徐士宽
 * @date 2017/3/13 11:46
 */
public interface UserMapper {

    public UserDTO getUserById(long id);

    public void addUse(UserDTO dto);

    public void updateUse(UserDTO dto);

    public UserDTO getUserByLogin(String login);

    public List<UserDTO> queryAllUser();

    public UserLearningParamsDTO getUserLearningParamsByUserId(long userId);

    public void addUserLearningParams(UserLearningParamsDTO dto);

}
