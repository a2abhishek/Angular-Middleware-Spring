package com.project.service;

import java.util.List;

import com.project.models.User;

public interface UserService {
	public boolean registerUser(User UserObj);
	public List<User> viewAllUser();
	public boolean deleteUser(User userObj);
	public User getUserByName(String userName);
	public boolean updateUser(User userObj);
	public User getUserByRole(String role);
	public User validateUser(String email, String password);
	public User getSeller();
	public User getBuyer(int id);
}
