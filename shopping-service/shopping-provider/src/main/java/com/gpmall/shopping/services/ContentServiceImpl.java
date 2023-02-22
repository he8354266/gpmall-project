package com.gpmall.shopping.services;

import com.gpmall.shopping.IContentService;
import com.gpmall.shopping.dal.persistence.PanelContentMapper;
import com.gpmall.shopping.dto.NavListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Override
    public NavListResponse queryNavList() {
        return null;
    }
}
