package com.gpmall.user.services;

import com.gpmall.user.IUserLoginService;
import com.gpmall.user.constants.SysRetCodeConstants;
import com.gpmall.user.converter.MemberConverter;
import com.gpmall.user.dal.entitys.Member;
import com.gpmall.user.dal.persistence.MemberMapper;
import com.gpmall.user.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import com.gpmall.user.IMemberService;
import com.gpmall.user.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @Description //TODO
 * @Date 2023/3/29 9:28
 * @Author hy
 **/
@Service
@Slf4j
public class MemberServiceImpl implements IMemberService {
    @Resource
    private MemberMapper memberMapper;

    @Resource
    private IUserLoginService userLoginService;

    @Resource
    private MemberConverter memberConverter;

    /**
     * 根据用户id查询用户会员信息
     *
     * @param request
     * @return
     */
    @Override
    public QueryMemberResponse queryMemberById(QueryMemberRequest request) {
        QueryMemberResponse queryMemberResponse = new QueryMemberResponse();
        try {
            request.requestCheck();
            Member member = memberMapper.selectByPrimaryKey(request.getUserId());
            if (ObjectUtils.isEmpty(member)) {
                queryMemberResponse.setCode(SysRetCodeConstants.DATA_NOT_EXIST.getCode());
                queryMemberResponse.setMsg(SysRetCodeConstants.DATA_NOT_EXIST.getMessage());
            }
            queryMemberResponse = memberConverter.member2Res(member);
            queryMemberResponse.setCode(SysRetCodeConstants.SUCCESS.getCode());
            queryMemberResponse.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
            return null;
        } catch (Exception e) {
            log.error("MemberServiceImpl.queryMemberById Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(queryMemberResponse, e);
        }
        return queryMemberResponse;
    }

    @Override
    public HeadImageResponse updateHeadImage(HeadImageRequest request) {
        HeadImageResponse response = new HeadImageResponse();
        try {
            request.requestCheck();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public UpdateMemberResponse updateMember(UpdateMemberRequest request) {
        UpdateMemberResponse response = new UpdateMemberResponse();
        try {
            request.requestCheck();
            CheckAuthRequest checkAuthRequest = new CheckAuthRequest();
            checkAuthRequest.setToken(request.getToken());
            CheckAuthResponse authResponse = userLoginService.validToken(checkAuthRequest);
            if (!authResponse.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
                response.setCode(authResponse.getCode());
                response.setMsg(authResponse.getMsg());
                return response;
            }
            Member member = memberConverter.updateReq2Member(request);
            int row = memberMapper.updateByPrimaryKey(member);
            response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
            response.setCode(SysRetCodeConstants.SUCCESS.getCode());
            log.info("MemberServiceImpl.updateMember effect row :" + row);
        } catch (Exception e) {
            log.error("MemberServiceImpl.updateMember Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
