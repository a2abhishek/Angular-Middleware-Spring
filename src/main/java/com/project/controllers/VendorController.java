package com.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.daos.ProductDao;
import com.project.daos.VendorProductDao;
import com.project.models.Products;
import com.project.models.User;
import com.project.models.VendorProduct;

@Controller
@CrossOrigin("http://localhost:4200")
public class VendorController {
	
	@Autowired
	VendorProductDao vendorDaoObj;
	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	ProductDao productDaoObj;
	
	
//	@PostMapping(value="/updateProductQuantity")
//	public ResponseEntity<?> addInVendorproductTable(@RequestParam(name="pId") int pId  , @RequestParam(name="quantity") int quantity)
//	{
//		User userObj=(User)session.getAttribute("uObj");							 	//Get userId from session
//		VendorProduct r=vendorDaoObj.checkProductForVendor(userObj.getUserId(), pId);   //check if product is already added, if present then update the quantity else add the quantity
//		if(r!=null) {
//			r.setQuantity(r.getQuantity()+quantity);      								//Quantity added to existing product's quantity
//		}
//		else {
//			r = new VendorProduct();													//else create new row for vendor product and set values 
//			r.setVendorId(userObj.getUserId());
//			r.setProductId(pId);
//			r.setQuantity(quantity);
//		}
//		
//		vendorDaoObj.add(r);                    										//call add method from VendorProductDao
//
//		return new ResponseEntity<String>("Person added successfully",HttpStatus.OK);
//	}
//	
	@RequestMapping(value="/updateProductQuantity",method=RequestMethod.GET)
	public ResponseEntity<?> addInVendorproductTable(@RequestParam(name="productId") int productId, 
			@RequestParam(name="quantity") int quantity,@RequestParam(name="vendorId")int vendorId)
	{
		
		VendorProduct r=vendorDaoObj.checkProductForVendor(vendorId, productId); 
		if(r!=null) {
			r.setQuantity(r.getQuantity()+quantity);      
		}
		else {
			r = new VendorProduct();			
			r.setVendorId(vendorId);
			r.setProductId(productId);
			r.setQuantity(quantity);
		}
		
		boolean re=vendorDaoObj.add(r);                
		
		 if(re) {
			 	return new ResponseEntity<Object>(r,HttpStatus.OK);
		 }
		 else
		 
			 return new ResponseEntity<String>("Problem in adding quantity",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@GetMapping(value = "/viewAllAvailableProducts")
	public ResponseEntity<?> viewAllAvailableProducts(@RequestParam(name="vendorId")int vendorId) {
		
		
		List<?> vendorProducts = vendorDaoObj.getAllProducts(vendorId);      //view products added by vendor getallProducts method in VendorProductDao
				
		return new ResponseEntity<List<?>>(vendorProducts,HttpStatus.OK);    											    //return view product

	}
}