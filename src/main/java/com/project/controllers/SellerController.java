package com.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.daos.POItemsDao;
import com.project.daos.PurchaseOrderDao;
import com.project.models.POItems;
import com.project.models.PurchaseOrder;

@Controller
public class SellerController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	PurchaseOrderDao poObj;

	
	@RequestMapping(value = "/viewPoList", method = RequestMethod.GET)
	public ResponseEntity<?> viewPoList(ModelMap map) {

		List<PurchaseOrder> polist = poObj.viewAllPo();
		map.addAttribute("polist", polist);
		session.setAttribute("polist", polist);
		return new ResponseEntity<List<PurchaseOrder>>(polist, HttpStatus.OK);
	}	
	
	@Autowired
	POItemsDao	poitems;
	
	@GetMapping(value = "/viewLineItems")
	public ResponseEntity<?> viewLineItems(@RequestParam(name="viewId") int viewId) {
		System.out.println(viewId);
		List<POItems> poitemslist = poitems.getLineItemsById(viewId);
		//map.addAttribute("poitemslist", poitemslist);
		System.out.println(poitemslist);
		session.setAttribute("poitemslist", poitemslist);
		return new ResponseEntity<List<POItems>>(poitemslist, HttpStatus.OK);
	}	
	
}
