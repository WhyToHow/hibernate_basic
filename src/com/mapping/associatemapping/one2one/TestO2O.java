package com.mapping.associatemapping.one2one;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.utils.HibernateUtils;

public class TestO2O {
	public static void main(String[] args){
		Session session = HibernateUtils.getSession();
		try{
			
			User user = new User();
			user.setUserName("张三");
			//注意顺序 先存用户 然后存身份证  因为身份证表中含有外键字段

			IdCard idCard = new IdCard();
			idCard.setCardNum("11112");
			idCard.setPlace("山东");
			idCard.setUser(user);
			
			session.save(user);
			session.save(idCard);
			
//			String queryString = "from IdCard";
//			Query query = session.createQuery(queryString);
//			List list = query.list();
//			System.out.println(list.size());
			
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.getSessionFactory().close();
		}
	}
}
