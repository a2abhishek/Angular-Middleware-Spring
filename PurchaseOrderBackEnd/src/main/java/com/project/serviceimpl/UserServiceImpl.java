package com.project.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.daos.UserDao;
import com.project.models.User;
import com.project.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;
	
	@Override
	public boolean registerUser(User uobj) {
		uobj.setIsActive("Y");
		uobj.setCreatedDate(LocalDate.now());
		uobj.setCreatedBy("System");
		uobj.setRole("Buyer");
		return userdao.registerUser(uobj);
	}

	@Override
	public List<User> viewAllUser() {
		// TODO Auto-generated method stub
		return userdao.viewAllUser();
	}

	@Override
	public boolean deleteUser(User userObj) {
		// TODO Auto-generated method stub
		return userdao.deleteUser(userObj);
	}

	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return userdao.getUserByName(userName);
	}

	@Override
	public boolean updateUser(User userObj) {
		// TODO Auto-generated method stub
		return userdao.updateUser(userObj);
	}

	@Override
	public User getUserByRole(String role) {
		// TODO Auto-generated method stub
		return userdao.getUserByRole(role);
	}

	@Override
	public User validateUser(String email, String password) {
		// TODO Auto-generated method stub
		return userdao.validateUser(email, password);
	}

	@Override
	public User getSeller() {
		// TODO Auto-generated method stub
		return userdao.getSeller();
	}

	@Override
	public User getBuyer(int id) {
		// TODO Auto-generated method stub
		return userdao.getBuyer(id);
	}
}