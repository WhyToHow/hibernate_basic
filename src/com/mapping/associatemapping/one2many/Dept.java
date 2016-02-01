package com.mapping.associatemapping.one2many;

import java.util.Set;

import com.mapping.associatemapping.many2one.Employee;


public class Dept {
	private Integer deptId;
	private String deptName;
	//一对多---一个部门对应多个员工
	private Set<Employee> employees;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	

}
