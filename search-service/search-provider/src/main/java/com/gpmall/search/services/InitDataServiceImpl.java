package com.gpmall.search.services;

import com.gpmall.search.InitDataService;
import com.gpmall.search.dal.persistence.ItemMapper;
import com.gpmall.search.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description //TODO
 * @Date 2023/6/21 16:37
 * @Author hy
 **/
@Slf4j
@Service
public class InitDataServiceImpl implements InitDataService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ProductConverter productConverter;

    @Override
    public void initItems() {

    }
}
