package com.gpmall.user.services;

import com.gpmall.user.IUserVerifyService;
import com.gpmall.user.dto.UserVerifyRequest;
import com.gpmall.user.dto.UserVerifyResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Description //TODO
 * @Date 2023/3/30 11:04
 * @Author hy
 **/
@Service
@Slf4j
public class UserVerifyServiceImpl implements IUserVerifyService {
    @Override
    public UserVerifyResponse verifyMemer(UserVerifyRequest userVerifyRequest) {
        return null;
    }
}
