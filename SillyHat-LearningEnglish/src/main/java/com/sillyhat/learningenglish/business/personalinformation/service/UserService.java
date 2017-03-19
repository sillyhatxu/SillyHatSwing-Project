package com.sillyhat.learningenglish.business.personalinformation.service;

import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserLearningParamsDTO;

import java.util.List;

/**
 * UserService
 *
 * @author 徐士宽
 * @date 2017/3/15 16:54
 */
public interface UserService {

    public UserDTO getUserById(long id);

    public void saveUse(UserDTO dto);

    public boolean checkUser(String login,String password);

    public List<UserDTO> queryAllUser();

    public UserLearningParamsDTO getUserLearningParamsByUserId(long userId);
}
