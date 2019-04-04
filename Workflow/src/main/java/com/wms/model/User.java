package com.wms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@NotNull
	private String userName;
	private String designation;
	private String password;
	
	@OneToMany(mappedBy = "user", orphanRemoval = true, cascade=CascadeType.ALL)
	private List<WorkflowInstance> workflowInstanceList = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "user_group_map", joinColumns = @JoinColumn(name = "fk_user"), 
	inverseJoinColumns = @JoinColumn(name="fk_group"))
	@JsonIgnoreProperties("userList")
    private List<UserGroup> groupList = new ArrayList<>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<UserGroup> groupList) {
		this.groupList = groupList;
	}
	
}
