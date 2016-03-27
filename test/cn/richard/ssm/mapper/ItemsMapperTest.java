package cn.richard.ssm.mapper;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.richard.ssm.po.Items;

public class ItemsMapperTest {

	private ApplicationContext applicationContext=null;
	
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	}

	@Test
	public void testSelectByPrimaryKey() {
		ItemsMapper itemsMapper=(ItemsMapper)applicationContext.getBean("itemsMapper");
		Items items=itemsMapper.selectByPrimaryKey(1);
		System.out.println(String.format("Items[name=%s,price=%f,Detail=%s]", items.getName(),
				items.getPrice(),items.getDetail()));
	}

	@Test
	public void testInsert() {
		Items items=new Items();
		items.setName("apple 6s");
		items.setPrice(5288f);
		items.setCreatetime(new Date());
		items.setDetail("apple 6s made in China");
		ItemsMapper itemsMapper= (ItemsMapper) applicationContext.getBean("itemsMapper");
		
		itemsMapper.insert(items);
		
	}

	@Test
	public void testSelectByExample() {
		ItemsMapper itemsMapper= (ItemsMapper) applicationContext.getBean("itemsMapper");
		List<Items> itemsList= itemsMapper.selectByExample(null);
		for(Items items : itemsList){
			System.out.println(items.getName());
		}
		
	}

}
