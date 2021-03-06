package com.wms.service;

import java.util.List;

import com.wms.model.User;
import com.wms.model.UserGroup;

public interface UserService {

	boolean doRegister(User user);
	User getUser(Long userid);
	List<User> getAllUsers();
	
	void addUserGroup(UserGroup grp);
	//List<User> getUserFromGroup(Long grpid);
		UserGroup getGroup(Long grpid);
		List<UserGroup> getAllGroups();
}
