package com.mapping.associatemapping.many2many;

import java.util.Set;

public class Developer {
	private Integer developerId;
	private String developerName;
	//员工可以有多个项目
	private Set<Project> projects;
	public Integer getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	

}
