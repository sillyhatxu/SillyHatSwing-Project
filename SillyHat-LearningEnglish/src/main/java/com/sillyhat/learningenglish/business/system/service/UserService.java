package com.sillyhat.learningenglish.business.system.service;

import com.sillyhat.learningenglish.business.system.dto.UserDTO;

/**
 * UserService
 *
 * @author 徐士宽
 * @date 2017/3/15 16:54
 */
public interface UserService {

    public UserDTO getUserById(String id);
}
