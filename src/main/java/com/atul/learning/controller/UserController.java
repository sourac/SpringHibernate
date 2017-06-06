package com.atul.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atul.learning.model.User;
import com.atul.learning.model.UserDao;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam(value = "email") String email, @RequestParam(value = "name") String name) {

		String userId = "";
		try {
			User user = new User(email, name);
			userDao.save(user);
			userId = String.valueOf(user.getId());

		} catch (Exception e) {
			return "error creating the user : " + e.toString();

		}

		return "User succesfully created with id : " + userId;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam(value = "id") long id) {
		try {
			User user = new User(id);
			userDao.delete(user);

		} catch (Exception e) {
			return "error deleting the user :" + e.toString();
		}
		return "user deleted successfully";

	}

	@RequestMapping(value = "/getbyemail", method = RequestMethod.GET)
	@ResponseBody
	public String getByEmail(@RequestParam(value = "email") String email) {
		String userId;
		String userName;
		try {
			User user = userDao.findByEmail(email);
			userId = String.valueOf(user.getId());
			userName = user.getName();

		} catch (Exception e) {
			return "User not found";

		}
		return "the user id : " + userId + " and name : " + userName;

	}

	@RequestMapping(value = "/getByName", method = RequestMethod.GET)
	@ResponseBody
	public String getByName(@RequestParam(value = "name") String name) {

		String id;
		try {
			User user = userDao.findByName(name);
			id = user.getName();

		} catch (Exception e) {
			return "user not found";

		}

		return "user found and  id : " + id;

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public String updateUser(@RequestParam(value = "id") long id, @RequestParam(value = "email") String email,

			@RequestParam(value = "name") String name) {
		try {
			User user = new User(id);
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);

		} catch (Exception e) {
			return "error updating the user : " + e.toString();
		}

		return "updated the user successfully";

	}

}
