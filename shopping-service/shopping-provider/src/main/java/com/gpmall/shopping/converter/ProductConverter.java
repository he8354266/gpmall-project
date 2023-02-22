package com.gpmall.shopping.converter;

import com.gpmall.shopping.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.gpmall.shopping.dal.entitys.Item;

import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/2/22 10:34
 * @Author hy
 **/
@Mapper(componentModel = "spring")
public interface ProductConverter {
    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "title", target = "productName"),
            @Mapping(source = "price", target = "salePrice"),
            @Mapping(source = "sellPoint", target = "subTitle"),
            @Mapping(source = "imageBig", target = "picUrl")
    })
    ProductDto item2Dto(Item item);

    List<ProductDto> items2Dto(List<Item> items);
}
