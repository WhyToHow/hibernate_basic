package com.mapping.associatemapping.many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.utils.HibernateUtils;

public class TestM2M {
	
	public static void main(String[] args){
		Session session = HibernateUtils.getSession();
		try{
			Project project1 = new Project();
			Project project2 = new Project();
			Project project3 = new Project();
			project1.setProjectName("火箭");
			project2.setProjectName("汽车");
			project3.setProjectName("飞机");
			
			Developer developer1 = new Developer();
			Developer developer2 = new Developer();
			Developer developer3 = new Developer();
			Developer developer4 = new Developer();
			Developer developer5 = new Developer();
			developer1.setDeveloperName("张三");
			developer2.setDeveloperName("李四");
			developer3.setDeveloperName("王五");
			developer4.setDeveloperName("赵六");
			Set<Developer> developers = new HashSet<>();
			developers.add(developer1);
			developers.add(developer2);
			developers.add(developer4);
			
			Set<Developer> developers2 = new HashSet<>();
			developers2.add(developer1);
			developers2.add(developer3);
			developers2.add(developer4);
			
			Set<Developer> developers3 = new HashSet<>();
			developers3.add(developer1);
			developers3.add(developer3);
			
			project1.setDevelopers(developers);
			project2.setDevelopers(developers2);
			project3.setDevelopers(developers3);
			
			session.save(project3);
			session.save(project1);
			session.save(project2);
			session.save(developer5);
			session.save(developer4);
			session.save(developer3);
			session.save(developer2);
			session.save(developer1);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.getSessionFactory().close();
		}
	}

}
