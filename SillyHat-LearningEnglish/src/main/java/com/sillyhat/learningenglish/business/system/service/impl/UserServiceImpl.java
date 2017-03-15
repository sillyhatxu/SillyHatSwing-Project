package com.sillyhat.learningenglish.business.system.service.impl;

import com.sillyhat.learningenglish.business.system.dto.UserDTO;
import com.sillyhat.learningenglish.business.system.mapper.UserMapper;
import com.sillyhat.learningenglish.business.system.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

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
    public UserDTO getUserById(String id) {
        return userMapper.getUserById(id);
    }
}
