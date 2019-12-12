package com.project.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.daos.ProductDao;
import com.project.models.Products;
import com.project.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	public boolean addProduct(Products productObj) {
		// TODO Auto-generated method stub
		return productDao.addProduct(productObj);
	}

	@Override
	public List<Products> viewAllProducts() {
		// TODO Auto-generated method stub
		return productDao.viewAllProducts();
	}

	@Override
	public boolean deleteProduct(Products productObj) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(productObj);
	}

	

	@Override
	public boolean updateProduct(Products productObj) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(productObj);
	}

	@Override
	public Products getProductByName(String productName) {
		// TODO Auto-generated method stub
		return productDao.getProductByName(productName);
	}

}
