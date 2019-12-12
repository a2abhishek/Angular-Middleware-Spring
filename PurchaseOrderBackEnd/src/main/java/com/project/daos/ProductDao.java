package com.project.daos;

import java.util.List;

import com.project.models.Products;

public interface ProductDao {
	
	public boolean addProduct(Products productObj);
	public List<Products> viewAllProducts();
	public boolean deleteProduct(Products productObj);
	public Products getProductByName(String productName);
	public boolean updateProduct(Products productObj);
	public Products getProductById(int productId);
}
