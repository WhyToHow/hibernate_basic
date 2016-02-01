package com.employee;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Oracle
 * 此为单表操作测试示例
 * 熟练掌握HQL查询 
 * 两个重点 一个是聚合函数的使用
 * 			第二个就是分页查询
 *
 */
public class ConnectEmployee {
	public static void main(String[] args){
		//获取配置对象
		Configuration config = new Configuration();
		//使用配置对象加载配置文件
		config.configure();
		//获取SessionFactory
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		//获取Session对象
		Session session = sessionFactory.openSession();
		
		//获取事物对象 并开启事务
		Transaction transaction = session.beginTransaction();
		
		//操作数据
		
		//首先测试查询
		//主键查询   懒加载用load方法
		Employee employee = (Employee) session.get(Employee.class, 1);
		//输出查询结果
		System.out.println(employee);
		
		//固定条件查询 
		//sql字符串中使用的是类及其属性 所以要注意大小写
		String sql = "from Employee where empName like \'%李%\'";
		Query query = session.createQuery(sql);
		List<Employee> list = (List<Employee>)query.list();
		System.out.println(list);
		
		//变量条件查询
		sql = "from Employee emp where emp.empName like :empName";
//		sql = "from Employee emp where emp.empName like ?";
		query = session.createQuery(sql);
		//query.setParameter(0, "张三");//Remember that ordinal parameters are 1-based! Position: 1
		query.setParameter("empName", "张三");
		list = (List<Employee>)query.list();
		System.out.println(list);
		
		//查询可使用order by排序
		
		//查询时可以部分查询 select new Employee(empId,empName) from Employee
		//但是需要在实体类中书写此构造方法
		
		//聚合函数在查询中的使用
		sql = "select max(emp.empId),count(1) from Employee emp";
//		sql = "select count(1) from Employee emp";
		query = session.createQuery(sql);
		List countList = query.list();//!!!!
		//list 存放的是结果对象数组的集合
		//使用迭代器取出其中的数组对象
		//但是注意现在结果集中就一个元素 所以不是数组 直接就是object对象
			//如果加一个属性元素则为数组
		Iterator iterator = countList.iterator();
		while(iterator.hasNext()){
//			Object obj = iterator.next();
			//取出的count是Long型
//			System.out.println(obj);
			Object[] obj = (Object[])iterator.next();
			System.out.println(obj[0]);
		}
		
		//分页查询
		//需设置两个参数 起始行 每页总行数 这里使用页码作为参数更有普遍意义(easyui 传过来的参数是page rows)
		int page = 2;//页码 起始页码为1
		int rows = 2;//每页显示的最大行数
		sql = "from Employee";
		query = session.createQuery(sql);
		query.setFirstResult((page-1)*rows);//page换算成起始行
		query.setMaxResults(rows);
		list = (List<Employee>)query.list();
		System.out.println("分页"+list);
		//hibernate查询语句
		//select * from ( select row_.*, rownum rownum_ from ( select employee0_.EMPID as EMPID1_0_, employee0_.EMPNAME as EMPNAME2_0_, employee0_.WORKDATE as WORKDATE3_0_ from EMPLOYEE employee0_ ) row_ where rownum <= ?) where rownum_ > ?

		
		
		//存储数据
		/*Employee employeeSave = new Employee();
		employeeSave.setEmpId(4);
		employeeSave.setEmpName("王五");
		employeeSave.setWorkDate(new Date());
		session.save(employeeSave);*/
		
		//更改数据 需要指定主键 而且更改时如果对象属性值null 会覆盖数据库的值
		//还有saveOrUpdate方法 存在主键则更改 不存在主键报错 没有赋值主键则保存（native）
		/*Employee employeeUpdate = new Employee();
		employeeUpdate.setEmpId(4);
		employeeUpdate.setEmpName("王四");
		//session.update(employeeUpdate);
		session.saveOrUpdate(employeeUpdate);*/

		//删除数据
		/*Employee employeeDelete = new Employee();
		employeeDelete.setEmpId(4);
		//保险起见 是先查询数据库 get(Employee.class,4)看看是否含有主键是4的数据，然后删除此对象
		session.delete(employeeDelete);*/
		
		
		//提交事务 不操作数据库数据可不用提交
		transaction.commit();
		//关闭Session与SessionFactory对象
		session.close();
		sessionFactory.close();
	}

}
