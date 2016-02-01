package com.mapping.associatemapping.many2one;

import org.hibernate.Session;

import com.mapping.associatemapping.one2many.Dept;
import com.utils.HibernateUtils;

/**
 * 配置是双向关联
 *
 *也有单向关联
 *	注意 配置了哪一方     那一方就拥有维护关联关系的权限
 */
public class TestM2O2M {
	public static void main(String[] args){
		Session session = HibernateUtils.getSession();
		
		try{
			
			Employee employee1 = new Employee();
			employee1.setEmployeeName("张三");
			
			Employee employee2 = new Employee();
			employee2.setEmployeeName("李四");
			
			Dept dept = new Dept();
			dept.setDeptName("谷歌");
			
			//这是使用部门维护职工  会多update语句。。。推荐用多的一方维护yi的一方
			/*//将员工对象保存到集合中
			Set<Employee> set = new HashSet<>();
			set.add(employee1);
			set.add(employee2);
			
			//将集合赋值给部门中的集合属性
			dept.setEmployees(set);*/
			
			//推荐使用多的一方操作一的一方
			employee1.setDept(dept);
			employee2.setDept(dept);
			
			
			
			
			session.save(dept);//且要注意 先保存多的一方
			//报错 org.hibernate.MappingException: Unknown entity: com.mapping.associatemapping.one2many.Dept
			//忘记配置主配置文件了
			session.save(employee1);
			session.save(employee2);
			session.getTransaction().commit();
			//提交应该在try内部 最后  如果报错 则不会提交。。。
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			
			session.getSessionFactory().close();
			//session.close();
			// org.hibernate.SessionException: Session was already closed
			//关闭sessionFactory后即关闭session了 所以不要继续再关闭了
		}
		
		
		
	}
}
