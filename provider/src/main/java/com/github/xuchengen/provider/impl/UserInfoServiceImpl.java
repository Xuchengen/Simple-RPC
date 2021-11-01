package com.github.xuchengen.provider.impl;

import com.github.xuchengen.api.dto.UserInfoDTO;
import com.github.xuchengen.api.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {

    @Override
    public UserInfoDTO queryById(Long id) {
        System.out.println("[根据用户ID查询用户信息]参数为：" + id);
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setId(123456L);
        userInfoDTO.setName("徐承恩");
        userInfoDTO.setAge((short) 18);
        userInfoDTO.setPhone("13111111111");
        System.out.println("[根据用户ID查询用户信息]结果为：" + userInfoDTO);
        return userInfoDTO;
    }

    @Override
    public UserInfoDTO createUserInfo(UserInfoDTO userInfoDTO) {
        System.out.println("[创建用户信息]参数为：" + userInfoDTO);
        userInfoDTO.setId(123456L);
        System.out.println("[创建用户信息]结果为：" + userInfoDTO);
        return userInfoDTO;
    }
}
