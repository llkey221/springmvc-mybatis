package cn.richard.ssm.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.richard.ssm.po.ItemsCustom;
import cn.richard.ssm.po.ItemsQueryVo;

public class ItemsMapperCustomTest {

	private ApplicationContext applicationContext=null;
	
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	}

	@Test
	public void testFindItemsList() throws Exception {
		ItemsMapperCustom itemsMapperCustom= (ItemsMapperCustom) applicationContext.getBean("itemsMapperCustom");
		List<ItemsCustom> itemsCustomsList=itemsMapperCustom.findItemsList(null);
		
		for(ItemsCustom itemsCustom : itemsCustomsList){
			System.out.println(String.format("ItemsCustom[name=%s,price=%f,detail=%s]", itemsCustom.getName(),
					itemsCustom.getPrice(),itemsCustom.getDetail()));
		}
		
	}

}
