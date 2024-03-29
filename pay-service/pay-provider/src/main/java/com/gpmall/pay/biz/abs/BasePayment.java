package com.gpmall.pay.biz.abs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gpmall.commons.result.AbstractRequest;
import com.gpmall.commons.result.AbstractResponse;
import com.gpmall.commons.tool.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.xml.validation.Validator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description //TODO
 * @Date 2023/7/4 10:54
 * @Author hy
 **/
public abstract class BasePayment implements Payment {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    public static Map<String, BasePayment> paymentMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        paymentMap.put(getPayChannel(), this);
    }

    /**
     * 获取验证器
     *
     * @return
     */
    public abstract Validator getValidator();

    /**
     * 创建上下文信息
     *
     * @param request
     * @return
     */
    public abstract Context createContext(AbstractRequest request);

    /**
     * 为下层的支付渠道的数据做好准备
     *
     * @param request
     * @param context
     * @throws BizException
     */
    public void prepare(AbstractRequest request, Context context) {
        SortedMap<String, Object> sParaTemp = new TreeMap<>();
        context.setsParaTemp(sParaTemp);
    }

    /**
     * 基本业务处理
     *
     * @param request
     * @param context
     * @return AbstractResponse
     * @throws BizException
     */
    public abstract AbstractResponse generalProcess(AbstractRequest request, Context context) throws BizException;

    /***
     * 基本业务处理完成后执行的后续操作
     * @param request
     * @param respond
     * @param context
     * @return
     * @throws BizException
     */
    public abstract void afterProcess(AbstractRequest request, AbstractResponse respond, Context context) throws BizException;

    /**
     * 核心处理器
     */
    @Override
    public <T extends AbstractResponse> T process(AbstractRequest request) throws BizException {
        log.info("Begin BasePayment.process:{}", JSON.toJSONString(request));
        AbstractResponse response = null;
        //创建上下文
        Context context = createContext(request);
        //验证
        getValidator().validate(request);
    }

    /**
     * 获取支付渠道
     *
     * @return
     */
    public abstract String getPayChannel();
}
