package com.gpmall.shopping.services;

import com.gpmall.shopping.IProductService;
import com.gpmall.shopping.constans.ShoppingRetCode;
import com.gpmall.shopping.constant.GlobalConstants;
import com.gpmall.shopping.converter.ContentConverter;
import com.gpmall.shopping.converter.ProductConverter;
import com.gpmall.shopping.dal.persistence.ItemDescMapper;
import com.gpmall.shopping.dal.persistence.ItemMapper;
import com.gpmall.shopping.dal.persistence.PanelContentMapper;
import com.gpmall.shopping.dal.persistence.PanelMapper;
import com.gpmall.shopping.dto.*;
import com.gpmall.shopping.services.cache.CacheManager;
import com.gpmall.shopping.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description //TODO
 * @Date 2023/3/2 15:21
 * @Author hy
 **/
@Service
@Slf4j
public class ProductServiceImpl implements IProductService {
    @Resource
    CacheManager cacheManager;
    @Resource
    ItemMapper itemMapper;
    @Resource
    ItemDescMapper itemDescMapper;
    @Resource
    ProductConverter productConverter;
    @Resource
    PanelMapper panelMapper;

    @Resource
    PanelContentMapper panelContentMapper;
    @Resource
    ContentConverter contentConverter;

    @Override
    public ProductDetailResponse getProductDetail(ProductDetailRequest request) {
        ProductDetailResponse response = new ProductDetailResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        try {
            cacheManager.checkCache(generatorProduceCacheKey(request));
        } catch (Exception e) {
            log.error("ProductServiceImpl.getProductDetail Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return null;
    }

    @Override
    public AllProductResponse getAllProduct(AllProductRequest request) {
        return null;
    }

    @Override
    public RecommendResponse getRecommendGoods() {
        return null;
    }

    private String generatorProduceCacheKey(ProductDetailRequest request) {
        StringBuilder stringBuilder = new StringBuilder(GlobalConstants.PRODUCT_ITEM_CACHE_KEY);
        stringBuilder.append(":").append(request.getId());
        return stringBuilder.toString();
    }
}
