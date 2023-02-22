package com.gpmall.shopping.controller;

import com.gpmall.commons.result.ResponseData;
import com.gpmall.commons.result.ResponseUtil;
import com.gpmall.shopping.ICartService;
import com.gpmall.shopping.constans.ShoppingRetCode;
import com.gpmall.shopping.dto.*;
import com.gpmall.shopping.form.CartForm;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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


    /**
     * 获得购物车列表
     *
     * @param request
     * @return
     */
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

    /**
     * 添加商品到购物车
     *
     * @param cartForm
     * @return
     */
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

    /**
     * 更新购物车中的商品
     *
     * @param cartForm
     * @return
     */
    @PutMapping("/carts")
    @ApiOperation("更新购物车中的商品")
    @ApiImplicitParam(name = "cartForm", value = "购物车信息", dataType = "CartForm", required = true)
    public ResponseData updateCarts(@RequestBody CartForm cartForm) {
        UpdateCartNumRequest request = new UpdateCartNumRequest();
        request.setChecked(cartForm.getChecked());
        request.setItemId(cartForm.getProductId());
        request.setNum(cartForm.getProductNum());
        request.setUserId(cartForm.getUserId());
        UpdateCartNumResponse response = iCartService.updateCartNum(request);
        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getMsg());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }


    /**
     * 删除购物车中的商品
     *
     * @return
     */
    @ApiOperation("删除购物车中的商品")
    @DeleteMapping("/carts/{uid}/{pid}")
    @ApiImplicitParams({@ApiImplicitParam(name = "uid", value = "用户ID", paramType = "path"), @ApiImplicitParam(name = "pid", value = "商品ID", paramType = "path")})
    public ResponseData deleteCarts(@PathVariable("uid") long uid, @PathVariable("pid") long pid) {
        DeleteCartItemRequest request = new DeleteCartItemRequest();
        request.setUserId(uid);
        request.setItemId(pid);
        DeleteCheckedItemResposne response = iCartService.deleteCartItem(request);
        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getMsg());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    /**
     * 对购物车的全选操作
     *
     * @param cartForm
     * @return
     */
    @ApiOperation("对购物车的全选操作")
    @PutMapping("/items")
    @ApiImplicitParam(name = "cartForm", value = "购物车信息", dataType = "CartForm", required = true)
    public ResponseData checkCarts(@RequestBody CartForm cartForm) {
        CheckAllItemRequest request = new CheckAllItemRequest();
        request.setChecked(cartForm.getChecked());
        request.setUserId(cartForm.getUserId());
        CheckAllItemResponse response = iCartService.checkAllCartItem(request);
        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getMsg());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    /**
     * 删除购物车中选中的商品
     *
     * @param id
     * @return
     */
    @ApiOperation("删除购物车中选中的商品")
    @DeleteMapping("/items/{id}")
    @ApiImplicitParam(name = "id", value = "商品ID", paramType = "path")
    public ResponseData deleteCheckCartItem(@PathVariable("id") Long id) {
        DeleteCheckedItemRequest request = new DeleteCheckedItemRequest();
        request.setUserId(id);
        request.setUserId(request.getUserId());
        DeleteCheckedItemResposne response = iCartService.deleteCheckedItem(request);
        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getMsg());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }
}
