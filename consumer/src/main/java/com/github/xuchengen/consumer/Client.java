package com.github.xuchengen.consumer;

import com.github.xuchengen.api.dto.UserInfoDTO;
import com.github.xuchengen.api.service.UserInfoService;

public class Client {

    public static void main(String[] args) {
        UserInfoService userInfoService = ProxyFacatory.getInstance(UserInfoService.class);
        UserInfoDTO userInfoDTO = userInfoService.queryById(123456L);
        System.out.println(userInfoDTO);
        UserInfoDTO userInfoDTO1 = new UserInfoDTO();
        userInfoDTO1.setName("小明");
        userInfoDTO1.setAge((short)18);
        userInfoDTO1.setPhone("18666666666");
        UserInfoDTO userInfo = userInfoService.createUserInfo(userInfoDTO1);
        System.out.println(userInfo);
    }

}
