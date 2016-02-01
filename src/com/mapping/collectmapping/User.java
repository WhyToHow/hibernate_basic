package com.mapping.collectmapping;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private Integer userId;
	private String userName;
	//一个用户对应多个地址
	//集合映射 的数据类型都为基本的数据类型
	private Set<String> address_set;
	private List<String> address_list;
	private Map<String,String> address_map;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Set<String> getAddress_set() {
		return address_set;
	}
	public void setAddress_set(Set<String> address_set) {
		this.address_set = address_set;
	}
	public List<String> getAddress_list() {
		return address_list;
	}
	public void setAddress_list(List<String> address_list) {
		this.address_list = address_list;
	}
	public Map<String, String> getAddress_map() {
		return address_map;
	}
	public void setAddress_map(Map<String, String> address_map) {
		this.address_map = address_map;
	}
	

}
