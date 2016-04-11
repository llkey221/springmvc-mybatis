package cn.richard.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.richard.ssm.po.ItemsCustom;

@Controller
public class JsonTestController {
	
	@RequestMapping("/jsonTest")
	public String jsonTest(){		
		return "json/test";
	}
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		
		return itemsCustom;
	}
	
	@RequestMapping("/requestKeyValue")
	public @ResponseBody ItemsCustom requestKeyValue( ItemsCustom itemsCustom){
		
		return itemsCustom;
	}
}
