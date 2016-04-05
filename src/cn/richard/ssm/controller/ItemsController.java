package cn.richard.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import cn.richard.ssm.controller.exception.CustomException;
import cn.richard.ssm.po.ItemListForm;
import cn.richard.ssm.po.Items;
import cn.richard.ssm.po.ItemsCustom;
import cn.richard.ssm.po.ItemsQueryVo;
import cn.richard.ssm.service.ItemService;

@Controller
public class ItemsController {
	
	@Autowired
	private ItemService itemService;
	
	@ModelAttribute("itemTypes")
	public Map<String, String> getItemTypes(){
		Map<String, String> itemTypes=new HashMap<String, String>();
		itemTypes.put("1", "数码");
		itemTypes.put("2", "生活");
		itemTypes.put("3", "家居");
		
		return itemTypes;
	}
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(String name,Items item,ItemsQueryVo itemsQueryVo) throws Exception {
		List<ItemsCustom> itemsCustoms= itemService.findItemsList(itemsQueryVo);
		
		ModelAndView mView=new ModelAndView();
		mView.addObject("itemsCustoms", itemsCustoms);
		mView.setViewName("item/itemList");
		return mView;
	}
	
	@RequestMapping("/queryItems2.action")
	public String queryItems2(Model model,String name,ItemsQueryVo itemsQueryVo)throws Exception{
		
		List<ItemsCustom> itemsCustomList=itemService.findItemsList(itemsQueryVo);
		
		model.addAttribute("itemsCustomList", itemsCustomList);
		return "item/itemList2";
	}
	
	@RequestMapping("/editItem")
	public ModelAndView editItem(Integer id)throws Exception{
		
		ItemsCustom itemsCustom=itemService.findItem(id);
		
		if(itemsCustom==null){
			throw new CustomException("修改的商品信息不存在。");
		}
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("itemsCustom", itemsCustom);
		modelAndView.setViewName("item/editItem");
		return modelAndView;
	}

	
	@RequestMapping("/editItemSubmit")
	public String editItemSubmit(Model model,Integer id,@Validated  ItemsCustom itemsCustom
			,BindingResult bindingResult,MultipartFile itemPic)throws Exception{
		
		if(bindingResult.hasErrors()){
			List<ObjectError> objectErrors= bindingResult.getAllErrors();
			
			for ( ObjectError objectError : objectErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
			
			model.addAttribute("allErrors", objectErrors);
			return "item/editItem";
		}
		String originalFilename = itemPic.getOriginalFilename();
		if(itemPic!=null&&originalFilename!=null&&originalFilename.length()>0){
			String basePath="E:\\Pritase_space\\java\\pic\\tmp\\";
			String newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			
			File file=new File(basePath+newFileName);
			itemPic.transferTo(file);
			
			itemsCustom.setPic(newFileName);
		}
		
		int count=itemService.editItemById(id, itemsCustom);

		if(count==0){
			return "item/editItem";
		}else{
			return "success";
		}
	}
	@RequestMapping("/editAllItems")
	public String editAllItems(Model model,Integer[] ids, ItemListForm itemListForm) throws Exception{
		
		for (ItemsCustom itemsCustom : itemListForm.itemsCustoms) {
			System.out.println(String.format("itemsCustom[name=%s,price=%f,detail=%s]",itemsCustom.getName(),
					itemsCustom.getPrice(),itemsCustom.getDetail()));
		}
		
		return "success";
	}
}
