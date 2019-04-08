package com.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.dao.UserDao;
import com.wms.model.User;
import com.wms.model.UserGroup;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User getUser(Long userid) {
		return userDao.getUser(userid);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void addUserGroup(UserGroup grp) {
		 userDao.addUserGroup(grp);
		/*
		 * try { UserGroup ugrp = new UserGroup(); ugrp.setUsers(grp.getUserList());
		 * ugrp.setUserGroupName(grp.getUserGroupName());
		 * ugrp.setDescription(grp.getDescription()); //Integer sequence = 1; // Since
		 * it is a bi-directional mapping we need to set workflow in task and task // in
		 * workflow for (Task task : workflowWrapper.getTaskList()) {
		 * task.setWorkflow(workflow); task.setSequence(sequence++); }
		 * userDao.addUserGroup(ugrp); } catch (Exception e) { e.printStackTrace(); return
		 * false; } return true;
		 */
	}

	@Override
	public UserGroup getGroup(Long grpid) {
		return userDao.getGroup(grpid);
	}

	@Override
	public List<UserGroup> getAllGroups() {
		return userDao.getAllGroups();
	}



}
