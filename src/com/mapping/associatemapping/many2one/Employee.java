package com.mapping.associatemapping.many2one;

import com.mapping.associatemapping.one2many.Dept;

public class Employee {
	private Integer employeeId;
	private String employeeName;
	//多对一  员工对部门是多对一的关系
	private Dept dept;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
}
