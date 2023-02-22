package com.gpmall.shopping.services;

import com.gpmall.shopping.IContentService;
import com.gpmall.shopping.constans.ShoppingRetCode;
import com.gpmall.shopping.constant.GlobalConstants;
import com.gpmall.shopping.converter.ContentConverter;
import com.gpmall.shopping.dal.entitys.PanelContent;
import com.gpmall.shopping.dal.persistence.PanelContentMapper;
import com.gpmall.shopping.dto.NavListResponse;
import com.gpmall.shopping.services.cache.CacheManager;
import com.gpmall.shopping.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/2/22 9:47
 * @Author hy
 **/
@Service
@Slf4j
public class ContentServiceImpl implements IContentService {
    @Resource
    private PanelContentMapper panelContentMapper;
    @Resource
    private ContentConverter contentConverter;
    @Resource
    private CacheManager cacheManager;

    @Override
    public NavListResponse queryNavList() {
        NavListResponse response = new NavListResponse();
        try {
            Example exampleContent = new Example(PanelContent.class);
            exampleContent.setOrderByClause("sort_order");
            Example.Criteria criteria = exampleContent.createCriteria();
            criteria.andEqualTo("panelId", GlobalConstants.HEADER_PANEL_ID);
            List<PanelContent> panelContents = panelContentMapper.selectByExample(exampleContent);
            //添加缓存操作 TODO
            cacheManager.setCache(GlobalConstants.PANEL_CONTENT_KEY, panelContents.toString(), 10);
            response.setPannelContentDtos(contentConverter.panelContents2Dto(panelContents));
            response.setCode(ShoppingRetCode.SUCCESS.getCode());
            response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("ContentServiceImpl.queryNavList Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
