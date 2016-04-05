package cn.richard.ssm.po;

import java.util.List;

public class ItemListForm {
	public List<ItemsCustom> itemsCustoms;
	
	public Integer [] ids;

	public List<ItemsCustom> getItemsCustoms() {
		return itemsCustoms;
	}

	public void setItemsCustoms(List<ItemsCustom> itemsCustoms) {
		this.itemsCustoms = itemsCustoms;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
}
