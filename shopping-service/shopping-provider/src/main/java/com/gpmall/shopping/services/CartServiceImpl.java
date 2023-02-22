package com.gpmall.shopping.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gpmall.shopping.ICartService;
import com.gpmall.shopping.constans.ShoppingRetCode;
import com.gpmall.shopping.constant.GlobalConstants;
import com.gpmall.shopping.dal.persistence.ItemMapper;
import com.gpmall.shopping.dto.*;
import com.gpmall.shopping.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description //TODO
 * @Date 2023/1/29 10:32
 * @Author hy
 **/
@Slf4j
@Service
public class CartServiceImpl implements ICartService {
    @Resource
    private RedissonClient redissonClient;
    @Resource
    private ItemMapper itemMapper;

    /**
     * 根据用户id获得购物车中的商品列表
     *
     * @Param request
     * @Date 2023/1/29 10:35
     * @Author hy
     **/
    @Override
    public CartListByIdResponse getCartListById(CartListByIdRequest request) {
        CartListByIdResponse response = new CartListByIdResponse();
        List<CartProductDto> productDtos = new ArrayList<>();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        try {
            Map<Object, Object> items = redissonClient.getMap(generatorCartItemKey(request.getUserId()));
            items.values().forEach(obj -> {
                CartProductDto cartProductDto = JSONObject.parseObject(obj.toString(), CartProductDto.class);
                productDtos.add(cartProductDto);
            });
            response.setCartProductDtos(productDtos);
        } catch (Exception e) {
            log.error("CartServiceImpl.getCartListById Occur Exception :" + e.getMessage());
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    /**
     * 添加商品到购物车
     *
     * @param request
     * @return AddCartResponse
     */
    @Override
    public AddCartResponse addToCart(AddCartRequest request) {
        AddCartResponse response = new AddCartResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        try {
            request.requestCheck();
            boolean exists = redissonClient.getMap(generatorCartItemKey(request.getUserId())).containsKey(request.getItemId());
            if (exists) {
                String cartItemJson = redissonClient.getMap(generatorCartItemKey(request.getUserId())).get(request.getItemId()).toString();
                CartProductDto cartProductDto = JSONObject.parseObject(cartItemJson, CartProductDto.class);
                cartProductDto.setProductNum(cartProductDto.getProductNum().longValue() + request.getNum().longValue());
                redissonClient.getMap(generatorCartItemKey(request.getUserId())).put(request.getItemId(), JSON.toJSON(cartProductDto).toString());
                return response;
            }

        } catch (Exception e) {
            log.error("CartServiceImpl.getCartListById Occur Exception :" + e.getMessage());
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public UpdateCartNumResponse updateCartNum(UpdateCartNumRequest request) {
        UpdateCartNumResponse response = new UpdateCartNumResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        try {
            RMap<Object, Object> itemMap = redissonClient.getMap(generatorCartItemKey(request.getUserId()));
            Object item = itemMap.get(request.getItemId());
            if (item != null) {
                CartProductDto cartProductDto = JSON.parseObject(item.toString(), CartProductDto.class);
                cartProductDto.setChecked(request.getChecked());
                cartProductDto.setProductNum(request.getNum().longValue());
                itemMap.put(request.getItemId(), JSON.toJSONString(cartProductDto));
            }
        } catch (Exception e) {
            log.error("CartServiceImpl.updateCartNum Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public CheckAllItemResponse checkAllCartItem(CheckAllItemRequest request) {
        CheckAllItemResponse response = new CheckAllItemResponse();
        try {
            RMap<Object, Object> items = redissonClient.getMap(generatorCartItemKey(request.getUserId()));
            items.values().forEach(obj -> {
                CartProductDto cartProductDto = (CartProductDto) obj;
                cartProductDto.setChecked(request.getChecked());
                items.put(cartProductDto.getProductId(), cartProductDto);
            });
            response.setCode(ShoppingRetCode.SUCCESS.getCode());
            response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("CartServiceImpl.checkAllCartItem Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public DeleteCheckedItemResposne deleteCartItem(DeleteCartItemRequest request) {
        DeleteCheckedItemResposne response = new DeleteCheckedItemResposne();
        try {
            RMap<Object, Object> itemMap = redissonClient.getMap(generatorCartItemKey(request.getUserId()));
            itemMap.values().forEach(item -> {
                CartProductDto cartProductDto = JSON.parseObject(item.toString(), CartProductDto.class);
                if (cartProductDto.getChecked().equals("true")) {
                    itemMap.remove(cartProductDto.getProductId());
                }
            });
            response.setCode(ShoppingRetCode.SUCCESS.getCode());
            response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("CartServiceImpl.deleteCheckedItem Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public DeleteCheckedItemResposne deleteCheckedItem(DeleteCheckedItemRequest request) {
        return null;
    }

    @Override
    public ClearCartItemResponse clearCartItemByUserID(ClearCartItemRequest request) {
        return null;
    }

    private String generatorCartItemKey(long userId) {
        StringBuilder sb = new StringBuilder(GlobalConstants.CART_ITEM_CACHE_PREFIX);
        sb.append(":").append(userId);
        return sb.toString();
    }
}
