package cn.richard.ssm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.richard.ssm.mapper.ItemsMapperCustom;
import cn.richard.ssm.po.ItemsCustom;
import cn.richard.ssm.po.ItemsQueryVo;
import cn.richard.ssm.service.ItemService;

public class ItemServiceImp implements ItemService  {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		List<ItemsCustom> itemsCustoms= itemsMapperCustom.findItemsList(null);

		return itemsCustoms;
	}

}
