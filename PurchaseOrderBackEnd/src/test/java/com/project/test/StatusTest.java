package com.project.test;

import static java.lang.System.out;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.DBConfig;
import com.project.daos.StatusDao;
import com.project.models.Status;

public class StatusTest {
	private static StatusDao statusDaoObj;


	@BeforeClass
	public static void init(){
		out.println("I m in init - start");
		//Created the object of Spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		
		statusDaoObj=context.getBean(StatusDao.class,"statusDao");
   	 	out.println("I m in init - end");
	}
	
	@Test
	@Ignore
	public void addStatusTest(){
		Status obj = new Status();
		obj.setstatusId(911);
		obj.setstatusName("Dispatched");
		boolean r=statusDaoObj.addStatus(obj);
		assertTrue("Problem in Adding Status", r);
	}
	
	@Test
	@Ignore
	public void udpateStatusTest(){
		boolean r=statusDaoObj.updateStatus("Dispatched to seller");
		assertTrue("Problem in Adding Status", r);
	}
	
	@Test
	
	public void getstatusByIdTest(){
		List<Status> statusObj=statusDaoObj.viewStatus();System.out.println(statusObj);
		assertNotNull("status with given id doesnt exist", statusObj);
	}
	
}
