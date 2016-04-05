package cn.richard.ssm.service.imp;

import java.io.Console;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.richard.ssm.mapper.ItemsMapper;
import cn.richard.ssm.mapper.ItemsMapperCustom;
import cn.richard.ssm.po.Items;
import cn.richard.ssm.po.ItemsCustom;
import cn.richard.ssm.po.ItemsQueryVo;
import cn.richard.ssm.service.ItemService;

public class ItemServiceImp implements ItemService  {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		List<ItemsCustom> itemsCustoms= itemsMapperCustom.findItemsList(itemsQueryVo);

		return itemsCustoms;
	}

	/**
	 * 查询商品详细信息
	 */
	@Override
	public ItemsCustom findItem(Integer id) throws Exception {
		Items items=itemsMapper.selectByPrimaryKey(id);
		
		ItemsCustom itemsCustom=null;
		if (items != null) {
			itemsCustom=new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}
		
		return itemsCustom;
	}

	@Override
	public int editItemById(Integer id, ItemsCustom itemsCustom) throws Exception {
		itemsCustom.setId(id);
		int count=itemsMapperCustom.updateByPrimaryKeySelective(itemsCustom);
		System.out.println(count);
		
		return count;
	}

}
