package com.gpmall.shopping.converter;

import com.gpmall.shopping.dal.entitys.Item;
import com.gpmall.shopping.dto.CartProductDto;

/**
 * @Description //TODO
 * @Date 2023/2/22 10:03
 * @Author hy
 **/
public class CartItemConverter {
    public static CartProductDto item2Dto(Item item) {
        CartProductDto cartProduct = new CartProductDto();
        cartProduct.setProductId(item.getId());
        cartProduct.setProductName(item.getTitle());
        cartProduct.setSalePrice(item.getPrice());
        cartProduct.setProductImg(item.getImages()[0]);
        if (item.getLimitNum() == null) {
            cartProduct.setLimitNum(Long.valueOf(item.getLimitNum()));
        } else if (item.getLimitNum() < 0 && item.getNum() < 0) {
            cartProduct.setLimitNum(Long.valueOf(10));
        } else {
            cartProduct.setLimitNum(Long.valueOf(item.getLimitNum()));
        }
        return cartProduct;
    }
}
