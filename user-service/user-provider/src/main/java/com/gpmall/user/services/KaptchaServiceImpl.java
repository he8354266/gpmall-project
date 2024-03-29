package com.gpmall.user.services;

import com.gpmall.user.IKaptchaService;
import com.gpmall.user.constants.SysRetCodeConstants;
import com.gpmall.user.dal.entitys.ImageResult;
import com.gpmall.user.dto.KaptchaCodeRequest;
import com.gpmall.user.dto.KaptchaCodeResponse;
import com.gpmall.user.utils.ExceptionProcessorUtils;
import com.gpmall.user.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description //校验码生成
 * @Date 2023/3/28 11:14
 * @Author hy
 **/
@Service
@Slf4j
public class KaptchaServiceImpl implements IKaptchaService {
    @Resource
    private RedissonClient redissonClient;
    private final String KAPTCHA_UUID = "kaptcha_uuid";

    @Override

    public KaptchaCodeResponse getKaptchaCode(KaptchaCodeRequest request) {
        KaptchaCodeResponse response = new KaptchaCodeResponse();
        try {
            ImageResult capText = VerifyCodeUtils.VerifyCode(140, 43, 4);
            response.setImageCode(capText.getImg());
            String uuid = UUID.randomUUID().toString();
            RBucket<Object> rBucket = redissonClient.getBucket(KAPTCHA_UUID + uuid);
            rBucket.set(capText.getCode());
            rBucket.expire(60, TimeUnit.SECONDS);
            response.setImageCode(capText.getImg());
            response.setUuid(uuid);
            response.setCode(SysRetCodeConstants.SUCCESS.getCode());
            response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("KaptchaServiceImpl.getKaptchaCode occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public KaptchaCodeResponse validateKaptchaCode(KaptchaCodeRequest request) {
        KaptchaCodeResponse response = new KaptchaCodeResponse();
        try {
            request.requestCheck();
            String redisKey = KAPTCHA_UUID + request.getUuid();
            RBucket<String> rBucket = redissonClient.getBucket(redisKey);
            String code = rBucket.get();
            log.info("请求的redisKey={},请求的code={},从redis获得的code={}", redisKey, request.getCode(), code);
            if (StringUtils.isNotBlank(code) && request.getCode().equalsIgnoreCase(code)) {
                response.setCode(SysRetCodeConstants.SUCCESS.getCode());
                response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
                return response;
            }
            response.setCode(SysRetCodeConstants.KAPTCHA_CODE_ERROR.getCode());
            response.setMsg(SysRetCodeConstants.KAPTCHA_CODE_ERROR.getMessage());
        } catch (Exception e) {
            log.error("KaptchaServiceImpl.validateKaptchaCode occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
