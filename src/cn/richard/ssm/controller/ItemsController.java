package cn.richard.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.richard.ssm.po.ItemsCustom;
import cn.richard.ssm.po.ItemsQueryVo;
import cn.richard.ssm.service.ItemService;

@Controller
public class ItemsController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("queryItems")
	public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {
		List<ItemsCustom> itemsCustoms= itemService.findItemsList(itemsQueryVo);
		
		ModelAndView mView=new ModelAndView();
		mView.addObject("itemsCustoms", itemsCustoms);
		mView.setViewName("");
		return mView;
	}
}
