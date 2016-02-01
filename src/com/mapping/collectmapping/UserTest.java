package com.mapping.collectmapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 本次测试 主要是集合映射
 * 注意集合映射中的数据类型都为基本数据类型
 * （如果想存对象 则要使用关联映射  见associateMapping）
 */
public class UserTest {
	public static void main(String[] args){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try{
			User user = new User();
//			user.setUserName("张三");
//			Set<String> set = new HashSet<String>();
//			set.add("朝阳");
//			set.add("三里");
//			user.setAddress_set(set);
			
//			user.setUserName("李四");
//			List<String> list = new ArrayList<>();
//			list.add("济南");
//			list.add("日照");
//			user.setAddress_list(list);
//			
//			user.setUserName("王五");
//			Map<String,String> map = new HashMap<>();
//			map.put("A001","济南");
//			map.put("A002",	"青岛");
//			user.setAddress_map(map);
			
			
//			session.save(user);
			
			user = (User)session.get(User.class, 4);
			List<String> list = user.getAddress_list();
			System.out.println("user3的address  "+list);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			transaction.commit();
			session.close();
			sessionFactory.close();
		}
	}

}
