package com.gpmall.user.services;

import com.gpmall.user.IUserLoginService;
import com.gpmall.user.constants.SysRetCodeConstants;
import com.gpmall.user.dal.entitys.Member;
import com.gpmall.user.dal.persistence.MemberMapper;
import com.gpmall.user.dal.persistence.UserMapper;
import com.gpmall.user.dto.CheckAuthRequest;
import com.gpmall.user.dto.CheckAuthResponse;
import com.gpmall.user.dto.UserLoginRequest;
import com.gpmall.user.dto.UserLoginResponse;
import com.gpmall.user.utils.ExceptionProcessorUtils;
import com.gpmall.user.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

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
        log.info("Begin UserLoginServiceImpl.login: request:" + request);
        UserLoginResponse response = new UserLoginResponse();
        try {
            request.requestCheck();
            Example example = new Example(Member.class);
            example.createCriteria().andEqualTo("state", 1).andEqualTo("username", request.getUserName());
            List<Member> members = memberMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("UserLoginServiceImpl.login Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);

        }
        return response;
    }

    @Override
    public CheckAuthResponse validToken(CheckAuthRequest request) {
        log.info("Begin UserLoginServiceImpl.validToken: request:" + request);
        CheckAuthResponse response = new CheckAuthResponse();
        response.setCode(SysRetCodeConstants.SUCCESS.getCode());
        response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
        try {
            request.requestCheck();
            String decodeMsg = JwtTokenUtils.builder().token(request.getToken()).build().freeJwt();
            if (StringUtils.isNotBlank(decodeMsg)) {
                log.info("validate success");
                response.setMsg(decodeMsg);
                return response;
            }
            response.setCode(SysRetCodeConstants.TOKEN_VALID_FAILED.getCode());
            response.setMsg(SysRetCodeConstants.TOKEN_VALID_FAILED.getMessage());
        } catch (Exception e) {
            log.error("UserLoginServiceImpl.validToken Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
