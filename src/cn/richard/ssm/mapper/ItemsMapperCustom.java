package cn.richard.ssm.mapper;

import cn.richard.ssm.po.Items;
import cn.richard.ssm.po.ItemsCustom;
import cn.richard.ssm.po.ItemsExample;
import cn.richard.ssm.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
	//查询商品信息列表
   public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}