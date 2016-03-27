package cn.richard.ssm.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.richard.ssm.po.ItemsCustom1;
import cn.richard.ssm.po.ItemsQueryVo;

public class ItemsMapperCustom1Test {

	private ApplicationContext applicationContext=null;
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	}

	@Test
	public void testFindItemsList() throws Exception {
		ItemsMapperCustom1 itemsMapperCustom1= (ItemsMapperCustom1) applicationContext.getBean("itemsMapperCustom1");
		ItemsQueryVo itemsQueryVo=new ItemsQueryVo();
		List<ItemsCustom1> itemsCustom1sList=itemsMapperCustom1.findItemsList(itemsQueryVo);
		
		for(ItemsCustom1 itemsCustom1 : itemsCustom1sList){
			System.out.println(String.format("ItemsCustom1[name=%s,price=%f,detail=%s]", itemsCustom1.getName(),
					itemsCustom1.getPrice(),itemsCustom1.getDetail()));
		}
	}

}
