package com.gpmall.user.services;

import com.gpmall.user.IUserLoginService;
import com.gpmall.user.dal.persistence.MemberMapper;
import com.gpmall.user.dal.persistence.UserMapper;
import com.gpmall.user.dto.CheckAuthRequest;
import com.gpmall.user.dto.CheckAuthResponse;
import com.gpmall.user.dto.UserLoginRequest;
import com.gpmall.user.dto.UserLoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @Description //TODO
 * @Date 2023/3/29 9:55
 * @Author hy
 **/
@Slf4j
@Service
public class UserLoginServiceImpl implements IUserLoginService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private MemberMapper memberMapper;

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        return null;
    }

    @Override
    public CheckAuthResponse validToken(CheckAuthRequest request) {
        return null;
    }
}
