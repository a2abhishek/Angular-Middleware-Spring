package com.project.test;

import static org.junit.Assert.assertTrue;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static java.lang.System.out;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.DBConfig;
import com.project.daos.UserDao;
import com.project.models.User;


public class UserTest {
	private static UserDao userDaoObj;

	@BeforeClass
	public static void init(){
		out.println("I m in init - start");
		//Created the object of Spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		//Passing the object of Configuration to the Spring container and refershing it
   	 	//context.register(DBConfig.class);
   	 	//context.refresh();
   	 	
   	 	//Asking the object of userDao from the spring container so that we can 
   	 	//test its methods.
		userDaoObj=context.getBean(UserDao.class,"userDao");
   	 	out.println("I m in init - end");
	}
	
	@Test
	@Ignore
	public void adduserTest(){
		User p=new User();
		p.setUserName("Rathore");
		boolean r=userDaoObj.registerUser(p);
		assertTrue("Problem in Adding User", r);
	}
	
	@Test
	@Ignore
	public void getuserByIdTest(){
		User userObj=userDaoObj.getUserByName("Realme X2 Pro");
		assertNotNull("user with given id doesnt exist", userObj);
	}
	
	
	
	@Test
	@Ignore
	public void getAlluserTest(){
		List<User> uList=userDaoObj.viewAllUser();
		Assert.assertNotEquals("Not Users Found...", uList.size(), 0);
	}
	@Test
	@Ignore
	public void deleteuser(){
		boolean uObj=userDaoObj.deleteUser(userDaoObj.getUserByName("Realme X2 Pro"));
		assertNotNull("User with given id doesnt exist", uObj);
	}
}
