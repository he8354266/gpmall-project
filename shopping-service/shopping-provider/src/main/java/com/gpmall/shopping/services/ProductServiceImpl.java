package com.gpmall.shopping.services;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gpmall.shopping.IProductService;
import com.gpmall.shopping.constans.ShoppingRetCode;
import com.gpmall.shopping.constant.GlobalConstants;
import com.gpmall.shopping.converter.ContentConverter;
import com.gpmall.shopping.converter.ProductConverter;
import com.gpmall.shopping.dal.entitys.Item;
import com.gpmall.shopping.dal.entitys.ItemDesc;
import com.gpmall.shopping.dal.persistence.ItemDescMapper;
import com.gpmall.shopping.dal.persistence.ItemMapper;
import com.gpmall.shopping.dal.persistence.PanelContentMapper;
import com.gpmall.shopping.dal.persistence.PanelMapper;
import com.gpmall.shopping.dto.*;
import com.gpmall.shopping.services.cache.CacheManager;
import com.gpmall.shopping.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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
            String json = cacheManager.checkCache(generatorProduceCacheKey(request));
            if (StringUtils.isNotBlank(json)) {
                ProductDetailDto productDetailDto = JSON.parseObject(json, ProductDetailDto.class);
                cacheManager.expire(generatorProduceCacheKey(request), GlobalConstants.PRODUCT_ITEM_EXPIRE_TIME);
                response.setProductDetailDto(productDetailDto);
                return response;
            }
            Item item = itemMapper.selectByPrimaryKey(request.getId().longValue());
            ProductDetailDto productDetailDto = new ProductDetailDto();
            productDetailDto.setProductId(request.getId().longValue());
            productDetailDto.setProductName(item.getTitle());
            productDetailDto.setSubTitle(item.getSellPoint());
            productDetailDto.setLimitNum(ObjectUtils.isEmpty(item.getNum()) ? item.getNum().longValue() : item.getLimitNum().longValue());
            productDetailDto.setSalePrice(item.getPrice());

            ItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(request.getId().longValue());
            productDetailDto.setDetail(itemDesc.getItemDesc());
            if (StringUtils.isNotBlank(item.getImage())) {
                String images[] = item.getImage().split(",");
                productDetailDto.setProductImageBig(images[0]);
                productDetailDto.setProductImageSmall(Arrays.asList(images));
            }
            response.setProductDetailDto(productDetailDto);
            //设置缓存
            cacheManager.setCache(generatorProduceCacheKey(request), JSON.toJSON(productDetailDto).toString(), GlobalConstants.PRODUCT_ITEM_EXPIRE_TIME);

        } catch (Exception e) {
            log.error("ProductServiceImpl.getProductDetail Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public AllProductResponse getAllProduct(AllProductRequest request) {
        AllProductResponse response = new AllProductResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        try {
            PageHelper.startPage(request.getPage(), request.getSize());
            String orderCol = "created";
            String orderDir = "desc";
            if (request.getSort().equals("1")) {
                orderCol = "price";
                orderDir = "asc";
            } else {
                orderCol = "price";
                orderDir = "desc";
            }
            List<Item> items = itemMapper.selectItemFront(request.getCid(), orderCol, orderDir, request.getPriceGt(), request.getPriceLte());
            PageInfo<Item> pageInfo = new PageInfo<>(items);
            List<ProductDto> productDtosList = productConverter.items2Dto(items);
            response.setProductDtoList(productDtosList);
            response.setTotal(pageInfo.getTotal());
        } catch (Exception e) {

        }
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
