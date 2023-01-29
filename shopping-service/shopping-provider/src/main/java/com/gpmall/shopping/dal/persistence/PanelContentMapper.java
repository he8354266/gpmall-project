package com.gpmall.shopping.dal.persistence;

import com.gpmall.commons.tool.tkmapper.TkMapper;
import com.gpmall.shopping.dal.entitys.PanelContent;
import com.gpmall.shopping.dal.entitys.PanelContentItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PanelContentMapper extends TkMapper<PanelContent> {

    List<PanelContentItem> selectPanelContentAndProductWithPanelId(@Param("panelId")Integer panelId);
}