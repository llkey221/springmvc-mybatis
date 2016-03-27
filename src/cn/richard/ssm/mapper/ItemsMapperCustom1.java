package cn.richard.ssm.mapper;

import java.util.List;

import cn.richard.ssm.po.ItemsCustom1;
import cn.richard.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom1 {
	public List<ItemsCustom1> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
