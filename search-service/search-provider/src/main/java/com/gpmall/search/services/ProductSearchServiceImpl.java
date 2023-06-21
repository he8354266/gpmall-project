package com.gpmall.search.services;

import com.gpmall.search.ProductSearchService;
import com.gpmall.search.converter.ProductConverter;
import com.gpmall.search.dto.SearchRequest;
import com.gpmall.search.dto.SearchResponse;
import com.gpmall.search.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @Description //TODO
 * @Date 2023/6/21 17:30
 * @Author hy
 **/
@Service
@Slf4j
public class ProductSearchServiceImpl implements ProductSearchService {
    @Resource
    private ProductRepository productRepository;

    @Resource
    private ProductConverter productConverter;

    @Resource
    private RedissonClient redissonClient;

    @Override
    public SearchResponse search(SearchRequest request) {
        return null;
    }

    @Override
    public SearchResponse fuzzySearch(SearchRequest request) {
        return null;
    }

    @Override
    public SearchResponse hotProductKeyword() {
        return null;
    }
}
