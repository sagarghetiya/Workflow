package com.wms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.wms.model.User;
import com.wms.model.UserGroup;
import com.wms.service.UserService;

@Controller

public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping({ "/createuser" })
	public String createUser() {
		return "createuser";
	}
	
	@GetMapping({ "/createusergroup" })
	public String createUserGroup() {
		return "createusergroup";
	}

	@PostMapping({ "/addusergroup" })
	public ResponseEntity<Void> addUserGroup(@Valid @RequestBody UserGroup userGroup, UriComponentsBuilder builder) {
		userService.addUserGroup(userGroup);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/getallusergroup")
	public ResponseEntity<List<UserGroup>> getAllUserGroups() {
		return new ResponseEntity<List<UserGroup>>(userService.getAllGroups(), HttpStatus.OK);
	}

	@PostMapping("/adduser")
	public ResponseEntity<Void> addUser(@Valid @RequestBody User user, UriComponentsBuilder builder) {
		boolean flag = userService.doRegister(user);
		if (flag == true) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {

			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userList = userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
}
