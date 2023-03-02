package com.gpmall.shopping.services;

import com.alibaba.fastjson.JSON;
import com.gpmall.shopping.IProductCateService;
import com.gpmall.shopping.constans.ShoppingRetCode;
import com.gpmall.shopping.constant.GlobalConstants;
import com.gpmall.shopping.converter.ProductCateConverter;
import com.gpmall.shopping.dal.entitys.ItemCat;
import com.gpmall.shopping.dal.persistence.ItemCatMapper;
import com.gpmall.shopping.dto.AllProductCateRequest;
import com.gpmall.shopping.dto.AllProductCateResponse;
import com.gpmall.shopping.dto.ProductCateDto;
import com.gpmall.shopping.services.cache.CacheManager;
import com.gpmall.shopping.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/3/2 15:03
 * @Author hy
 **/
@Service
@Slf4j
public class ProductCateServiceImpl implements IProductCateService {
    @Resource
    ItemCatMapper itemCatMapper;
    @Resource
    CacheManager cacheManager;
    @Resource
    ProductCateConverter productCateConverter;

    @Override
    public AllProductCateResponse getAllProductCate(AllProductCateRequest request) {
        AllProductCateResponse response = new AllProductCateResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        try {
            String json = cacheManager.checkCache(GlobalConstants.PRODUCT_CATE_CACHE_KEY);
            if (StringUtils.isNotBlank(json)) {
                List<ProductCateDto> productCateDtos = JSON.parseArray(json, ProductCateDto.class);
                response.setProductCateDtoList(productCateDtos);
                return response;
            }
            Example itemCatExample = new Example(ItemCat.class);
            String orderCol = "sort_order";
            String orderDir = "asc";
            if (request.getSort().equals("1")) {
                orderCol = "sort_order";
                orderDir = "asc";
            } else {
                orderCol = "sort_order";
                orderDir = "desc";
            }
            itemCatExample.setOrderByClause(orderCol + " " + orderDir);
            List<ItemCat> itemCats = itemCatMapper.selectByExample(itemCatExample);
            List<ProductCateDto> productCateDtoList = productCateConverter.items2Dto(itemCats);
            response.setProductCateDtoList(productCateDtoList);
            //设置缓存
            cacheManager.setCache(genProductCateCacheKey(), JSON.toJSONString(productCateDtoList), GlobalConstants.PRODUCT_CATE_EXPIRE_TIME);
        } catch (Exception e) {
            log.error("ProductCateServiceImpl.getAllProductCate Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    private String genProductCateCacheKey() {
        return GlobalConstants.PRODUCT_CATE_CACHE_KEY;
    }
}
