package com.project.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.daos.ProductDao;
import com.project.daos.PurchaseOrderDao;
import com.project.daos.UserDao;
import com.project.models.POItems;
import com.project.models.Products;
import com.project.models.PurchaseOrder;
import com.project.models.User;
import com.project.service.ProductService;
import com.project.service.UserService;

@Controller
@CrossOrigin("http://localhost:4200")
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	//private static final Logger logger = Logger.getLogger(HomeController.class);
	//===================HomePage========================
	
//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public String homeController(ModelMap map ) {
//	
//		map.addAttribute("msg", "Welcome to Purchase Order");
//
//	return "HomePage";
//
//	}
//	
//	//==============================Register Page==========================
//	
//	@RequestMapping(value = "/getRegister", method = RequestMethod.GET)
//	public ModelAndView registerUser(@Valid @ModelAttribute("userObj") User userObj, BindingResult result) {
//
//			if (result.hasErrors()) {
//
//				System.out.println(result.getAllErrors());
//
//				ModelAndView mv = new ModelAndView("Register");
//				mv.addObject("error", "User has not registered");
//				return mv;
//			}
//
//			try {
//				ModelAndView mv = new ModelAndView("Login");
//				mv.addObject("login", new User());
//				userService.registerUser(userObj);
//				mv.addObject("msg", "User has been registered succesfully. Now u can Login");
//				return mv;
//
//			} catch (Exception e) {
//				e.printStackTrace();
////				logger.error("error in registerUserDetailcontroller" + e.getMessage());
//			}
//			return null;
//
//		}
//	
//	//===============================Login Page=========================
//	@RequestMapping(value = "/getLogin", method = RequestMethod.GET)
//	public String LoginUser(ModelMap map) {		
//		return "Login";
//	}	

	@PostMapping("/user")
	public ResponseEntity<?> addPerson(@RequestBody User userObj) {
		boolean b = userService.registerUser(userObj);
		if(b) {
			return new ResponseEntity<String>("Person added successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Problem in adding Person", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//============================Login Validations=============================	
	
	@Autowired
	PurchaseOrderDao poDao;
	
	@Autowired
	ProductDao productDao;
	
	
	
	@PostMapping(value="/userLogin")
	public ResponseEntity<?> validateUser(@RequestParam(name="userEmail") String userEmail ,@RequestParam(name="userPass") String userPass,ModelMap map)
	{
		User uObj = userService.validateUser(userEmail, userPass);
		
		if(uObj==null)
		{
			return new ResponseEntity<String>("No person to validate", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			session.setAttribute("uObj",uObj);
			System.out.println();
			if(uObj.getRole().equals("Buyer") && uObj.getIsActive().equals("Y")) {
			return new ResponseEntity<Object>(uObj,HttpStatus.OK);
			}
			else if(uObj.getRole().equals("Vendor") && uObj.getIsActive().equals("Y")) {
				return new ResponseEntity<Object>(uObj,HttpStatus.OK);
			}
			else if(uObj.getRole().equals("Seller") && uObj.getIsActive().equals("Y")) {
			
				return new ResponseEntity<Object>(uObj,HttpStatus.OK);
			}
			return new ResponseEntity<String>("Some problem in validating", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping(value = "/viewProducts")
	public ResponseEntity<?> viewAllProducts(ModelMap map) {

		List<Products> pList =  productDao.viewAllProducts();
		return new ResponseEntity<List<Products>>(pList, HttpStatus.OK);
	}
	
	@PostMapping(value="/purchaseOrder/{buyerId}")
	public ResponseEntity<?> raisePurchaseOrder(@PathVariable(name="buyerId") int buyerId,@RequestBody List<POItems> poItemsList) {
		
		
		System.out.println("Buyer Id : "+buyerId);
		
		for(POItems obj:poItemsList) {
			System.out.println(obj);
		}
		
		PurchaseOrder poObj=new PurchaseOrder();
		poObj.setBuyerObj(userService.getBuyer(buyerId));
		poObj.setSellerObj(userService.getSeller());
		poObj.setStatus("Sent to Seller");
		poObj.setCreatedDate(LocalDate.now());
		
		for(POItems obj:poItemsList) {
		
			obj.setProductObj(productDao.getProductById(obj.getProductId()));
			obj.setPurchaseOrderObj(poObj);
		}
		poObj.setPoItemsObj(poItemsList);		
		
		poDao.addPo(poObj);
		 if(poObj!=null) {
			 	return new ResponseEntity<PurchaseOrder>(poObj,HttpStatus.OK);
		 }
		 else
		 
			 return new ResponseEntity<String>("Problem in raising request",HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	
}