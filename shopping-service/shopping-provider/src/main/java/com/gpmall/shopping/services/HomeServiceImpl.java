package com.gpmall.shopping.services;

import com.alibaba.fastjson.JSON;
import com.gpmall.shopping.IHomeService;
import com.gpmall.shopping.constans.ShoppingRetCode;
import com.gpmall.shopping.constant.GlobalConstants;
import com.gpmall.shopping.converter.ContentConverter;
import com.gpmall.shopping.dal.entitys.Panel;
import com.gpmall.shopping.dal.entitys.PanelContentItem;
import com.gpmall.shopping.dal.persistence.PanelContentMapper;
import com.gpmall.shopping.dal.persistence.PanelMapper;
import com.gpmall.shopping.dto.HomePageResponse;
import com.gpmall.shopping.dto.PanelDto;
import com.gpmall.shopping.services.cache.CacheManager;
import com.gpmall.shopping.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description //TODO
 * @Date 2023/2/22 11:00
 * @Author hy
 **/
@Slf4j
@Service
public class HomeServiceImpl implements IHomeService {
    @Resource
    private PanelMapper panelMapper;
    @Resource
    private PanelContentMapper panelContentMapper;
    @Resource
    private ContentConverter contentConverter;

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private CacheManager cacheManager;

    @Override
    public HomePageResponse homepage() {
        log.info("Begin HomeServiceImpl.homepage");
        HomePageResponse response = new HomePageResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        try {
            String json = cacheManager.checkCache(GlobalConstants.HOMEPAGE_CACHE_KEY);
            if (StringUtils.isNoneEmpty(json)) {
                List<PanelDto> panelDtoList = JSON.parseArray(json, PanelDto.class);
                Set<PanelDto> panelDtos = new HashSet<>(panelDtoList);
                response.setPanelContentItemDtos(panelDtos);
                return response;
            }
            Example panelExample = new Example(Panel.class);
            Example.Criteria criteria = panelExample.createCriteria();
            criteria.andEqualTo("position", 0);
            criteria.andEqualTo("status", 1);
            panelExample.setOrderByClause("sort_order");
            List<Panel> panels = panelMapper.selectByExample(panelExample);
            Set<PanelDto> panelContentItemDtos = new HashSet<PanelDto>();
            panels.parallelStream().forEach(panel -> {
                List<PanelContentItem> panelContentItems = panelContentMapper.selectPanelContentAndProductWithPanelId(panel.getId());
                PanelDto panelDto = contentConverter.panen2Dto(panel);
                if (CollectionUtils.isNotEmpty(panelContentItems)) {
                    panelDto.setPanelContentItems(contentConverter.panelContentItem2Dto(panelContentItems));
                    panelContentItemDtos.add(panelDto);
                }
            });
            cacheManager.setCache(GlobalConstants.HOMEPAGE_CACHE_KEY, JSON.toJSONString(panelContentItemDtos), GlobalConstants.HOMEPAGE_EXPIRE_TIME);
            response.setPanelContentItemDtos(panelContentItemDtos);
        } catch (Exception e) {
            log.error("HomeServiceImpl.homepage Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
