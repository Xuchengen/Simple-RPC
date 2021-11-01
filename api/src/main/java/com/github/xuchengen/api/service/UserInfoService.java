package com.github.xuchengen.api.service;

import com.github.xuchengen.api.annotation.ServiceMappend;
import com.github.xuchengen.api.dto.UserInfoDTO;

@ServiceMappend(value = "com.github.xuchengen.provider.impl.UserInfoServiceImpl")
public interface UserInfoService {

    /**
     * 根据用户ID查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserInfoDTO queryById(Long id);

    /**
     * 创建用户信息
     *
     * @param userInfoDTO 用户信息
     * @return 用户信息
     */
    UserInfoDTO createUserInfo(UserInfoDTO userInfoDTO);
}
