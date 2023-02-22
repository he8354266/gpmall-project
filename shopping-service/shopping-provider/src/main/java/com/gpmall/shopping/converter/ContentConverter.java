package com.gpmall.shopping.converter;

import com.gpmall.shopping.dal.entitys.Panel;
import com.gpmall.shopping.dal.entitys.PanelContent;
import com.gpmall.shopping.dal.entitys.PanelContentItem;
import com.gpmall.shopping.dto.PanelContentDto;
import com.gpmall.shopping.dto.PanelContentItemDto;
import com.gpmall.shopping.dto.PanelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/2/22 10:19
 * @Author hy
 **/
@Mapper(componentModel = "spring")
public interface ContentConverter {

    @Mappings({})
    PanelContentDto panelContent2Dto(PanelContent panelContent);

    @Mappings({})
    PanelContentDto panelContentItem2Dto(PanelContentItem panelContentItem);

    @Mappings({})
    PanelDto panen2Dto(Panel panel);

    List<PanelContentDto> panelContents2Dto(List<PanelContent> panelContents);

    List<PanelContentItemDto> panelContentItem2Dto(List<PanelContentItem> panelContentItems);
}
