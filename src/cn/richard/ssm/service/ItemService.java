package cn.richard.ssm.service;

import java.util.List;

import cn.richard.ssm.po.ItemsCustom;
import cn.richard.ssm.po.ItemsQueryVo;

public interface ItemService {
	//查询商品列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//查询商品详细信息
	public ItemsCustom findItem(Integer id)throws Exception;
	
	//修改单个商品信息
	int editItemById(Integer id,ItemsCustom itemsCustom)throws Exception;
	
}
