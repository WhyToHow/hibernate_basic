package com.mapping.associatemapping.many2many;

import java.util.Set;

public class Project {
	private Integer projectId;
	private String projectName;
	//项目下 有多个员工
	private Set<Developer> developers;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Set<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}
	
}
