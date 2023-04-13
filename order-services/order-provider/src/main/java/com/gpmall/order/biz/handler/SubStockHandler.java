package com.gpmall.order.biz.handler;

import com.gpmall.commons.tool.exception.BaseBusinessException;
import com.gpmall.order.biz.context.CreateOrderContext;
import com.gpmall.order.biz.context.TransHandlerContext;
import com.gpmall.order.dal.entitys.Stock;
import com.gpmall.order.dal.persistence.OrderItemMapper;
import com.gpmall.order.dal.persistence.StockMapper;
import com.gpmall.order.dto.CartProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Description //TODO
 * @Date 2023/4/13 9:45
 * @Author hy
 **/
public class SubStockHandler extends AbstractTransHandler {
    @Resource
    private StockMapper stockMapper;
    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public boolean handler(TransHandlerContext context) {
        CreateOrderContext createOrderContext = (CreateOrderContext) context;
        List<CartProductDto> cartProductDtoList = createOrderContext.getCartProductDtoList();
        //item_ids
        List<Long> itemIds = createOrderContext.getBuyProductIds();
        //排序
        itemIds.sort(Long::compareTo);
        //一次性锁ids
        List<Stock> list = stockMapper.findStocksForUpdate(itemIds);
        if (CollectionUtils.isEmpty(list)) {
            throw new BaseBusinessException("库存未初始化");
        }
        if (itemIds.size() != list.size()) {
            throw new BaseBusinessException("有商品未初始化库存,请在如下商品id中检查库存状态：" + itemIds);
        }
        list.stream().forEach(stock -> {
            cartProductDtoList.stream().forEach(item -> {
                if (Objects.equals(item.getProductId(), stock.getItemId())) {
                    if (stock.getStockCount() < item.getProductNum()) {
                        throw new BaseBusinessException(stock.getItemId() + "库存不足");
                    }
                    stock.setLockCount(item.getProductNum().intValue());
                    stock.setStockCount(-item.getProductNum());
                    stockMapper.updateStock(stock);
                    return;
                }
            });
        });
        return true;
    }
}
