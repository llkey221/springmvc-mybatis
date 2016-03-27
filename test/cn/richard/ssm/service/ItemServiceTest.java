package cn.richard.ssm.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.richard.ssm.po.ItemsCustom;

public class ItemServiceTest {

	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}

	@Test
	public void testFindItemsList() throws Exception {
		ItemService itemService= (ItemService) applicationContext.getBean("itemService");
		
		List<ItemsCustom> itemsCustoms= itemService.findItemsList(null);
		
		for(ItemsCustom itemsCustom : itemsCustoms){
			System.out.println(String.format("ItemsCustom[name=%s,price=%f,detail=%s]", itemsCustom.getName(),
					itemsCustom.getPrice(),itemsCustom.getDetail()));
		}
	}

}
