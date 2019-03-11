package com.xiang.oauth2.server.service;

import com.xiang.oauth2.server.domain.user.UserAccount;

import java.util.List;

/**
 * @author Jiangcheng Xiang
 */
public interface UserService {
    void delete(Long id);

    List findAll();

    UserAccount save(UserAccount user);
}
