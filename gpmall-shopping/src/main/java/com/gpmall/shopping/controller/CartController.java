package com.gpmall.shopping.controller;

import com.gpmall.commons.result.ResponseData;
import com.gpmall.commons.result.ResponseUtil;
import com.gpmall.shopping.ICartService;
import com.gpmall.shopping.constans.ShoppingRetCode;
import com.gpmall.shopping.dto.AddCartRequest;
import com.gpmall.shopping.dto.AddCartResponse;
import com.gpmall.shopping.dto.CartListByIdRequest;
import com.gpmall.shopping.dto.CartListByIdResponse;
import com.gpmall.shopping.form.CartForm;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description //TODO
 * @Date 2023/1/31 11:36
 * @Author hy
 **/
@RestController
@RequestMapping("/shopping")
public class CartController {

    @Reference(timeout = 3000)
    private ICartService iCartService;


    @GetMapping("/carts")
    @ApiOperation("获得购物车列表")
    public ResponseData carts(HttpServletRequest request) {
//        String userInfo = request.getAttribute(TokenIntercepter.USER_INFO_KEY);
//        JSONObject jsonObject = JSON.parseObject(userInfo);
//        long uid = Long.parseLong(jsonObject.getString("uid"));
        CartListByIdRequest cartListByIdRequest = new CartListByIdRequest();
        cartListByIdRequest.setUserId(62L);
        CartListByIdResponse response = iCartService.getCartListById(cartListByIdRequest);
        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getCartProductDtos());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    @PostMapping("/carts")
    @ApiOperation("添加商品到购物车")
    @ApiImplicitParam(name = "cartForm", value = "购物车信息", dataType = "CartForm", required = true)
    public ResponseData carts(@RequestBody CartForm cartForm) {
        AddCartRequest request = new AddCartRequest();
        request.setItemId(cartForm.getProductId());
        request.setNum(cartForm.getProductNum());
        request.setUserId(cartForm.getUserId());
        AddCartResponse response = iCartService.addToCart(request);
        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getMsg());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }
}
