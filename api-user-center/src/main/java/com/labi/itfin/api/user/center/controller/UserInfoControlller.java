package com.labi.itfin.api.user.center.controller;

import com.labi.itfin.basics.facade.userCenter.dto.*;
import com.labi.itfin.basics.facade.userCenter.facade.UserInfoFacadeService;
import com.labi.itfin.common.constant.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value="/userCenter/user")
public class UserInfoControlller {
    @Autowired
    private UserInfoFacadeService UserInfoFacadeService;

    @GetMapping(value = "/userInfo{pid}")
    public Result<UserDTO> getUserInfo(@PathVariable(name = "pid") Long pid){
        Result<UserDTO> userInfo = UserInfoFacadeService.getUserInfo(pid);
        return userInfo;
    }


















}
