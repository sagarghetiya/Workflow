package com.wms.dao;

import java.util.List;

import com.wms.model.User;
import com.wms.model.UserGroup;

public interface UserDao {
	
	boolean registerExists(String username, String email);
	void doRegister(User user);
	User getUser(Long userid);
	List<User> getAllUsers();
	
	void addUserGroup(UserGroup grp);
	UserGroup getGroup(Long grpid);
	List<UserGroup> getAllGroups();
}
