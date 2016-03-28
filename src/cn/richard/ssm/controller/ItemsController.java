package cn.richard.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.richard.ssm.po.Items;
import cn.richard.ssm.po.ItemsCustom;
import cn.richard.ssm.po.ItemsQueryVo;
import cn.richard.ssm.service.ItemService;

@Controller
public class ItemsController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(String name,Items item,ItemsQueryVo itemsQueryVo) throws Exception {
		List<ItemsCustom> itemsCustoms= itemService.findItemsList(itemsQueryVo);
		
		ModelAndView mView=new ModelAndView();
		mView.addObject("itemsCustoms", itemsCustoms);
		mView.setViewName("item/itemList");
		return mView;
	}
	@RequestMapping("/editItem")
	public ModelAndView editItem(Integer id)throws Exception{
		
		ItemsCustom itemsCustom=itemService.findItem(id);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("itemsCustom", itemsCustom);
		modelAndView.setViewName("item/editItem");
		return modelAndView;
	}
	
	@RequestMapping("/editItemSubmit")
	public String editItemSubmit(Model model,ItemsCustom itemsCustom)throws Exception{
		
		
		return "success";
	}
}
