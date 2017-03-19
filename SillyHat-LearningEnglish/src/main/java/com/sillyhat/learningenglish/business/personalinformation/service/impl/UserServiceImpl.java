package com.sillyhat.learningenglish.business.personalinformation.service.impl;

import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserLearningParamsDTO;
import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.business.system.mapper.UserMapper;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.MD5Util;
import com.sillyhat.learningenglish.utils.cache.SystemCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author 徐士宽
 * @date 2017/3/15 16:54
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO getUserById(long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void saveUse(UserDTO dto) {
        UserDTO user = SystemCache.getUserCache();
        dto.setUpdatedUser(user.getId());
        dto.setPassword(MD5Util.toMD5Upper(dto.getPassword()));
        if(dto != null && dto.getId() == 0l){
            userMapper.updateUse(dto);
        }else{
            dto.setCreatedUser(user.getId());
//            dto.setId(UUIDUtils.getNextUUID());
            userMapper.addUse(dto);
        }
    }

    @Override
    public boolean checkUser(String login, String password) {
        UserDTO user = userMapper.getUserByLogin(login);
        if(user != null){
            if(user.getPassword().equals(MD5Util.toMD5Upper(password))){
                SystemCache.putUserCache(Constants.CURRENT_USER,user);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<UserDTO> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public synchronized UserLearningParamsDTO getUserLearningParamsByUserId(long userId) {
        UserLearningParamsDTO dto = userMapper.getUserLearningParamsByUserId(userId);
        if(dto == null){
            dto = new UserLearningParamsDTO();
            dto.setUserId(userId);
            dto.setLearningNum(Constants.DEFAULT_LEARNING_NUM);
            dto.setReviewNum(Constants.DEFAULT_REVIEW_NUM);
            dto.setCreatedUser(userId);
            dto.setUpdatedUser(userId);
            userMapper.addUserLearningParams(dto);
        }
        return dto;
    }
}
