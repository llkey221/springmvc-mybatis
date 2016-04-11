package cn.richard.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.richard.ssm.po.ItemsCustom;
import cn.richard.ssm.service.ItemService;

@Controller
public class RestController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="items/{id}")
	public @ResponseBody ItemsCustom items(@PathVariable(value="id") Integer id) throws Exception{
		
		ItemsCustom itemsCustom = itemService.findItem(id);
		
		if(itemsCustom==null){
			itemsCustom=new ItemsCustom();
		}
		
		return itemsCustom;
	}
}
