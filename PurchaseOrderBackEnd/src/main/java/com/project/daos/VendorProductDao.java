package com.project.daos;

import java.util.List;

import com.project.models.Products;
import com.project.models.VendorProduct;

public interface VendorProductDao {
	
	public Products getProductById(int pId) ;
	public List<Products> getAllProducts(int id);
	public boolean add(VendorProduct vObj);
	public VendorProduct checkProductForVendor(int vendorId,int productId);


}