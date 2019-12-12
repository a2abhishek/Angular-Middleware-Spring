package com.project.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.models.Products;
import com.project.models.VendorProduct;
import com.project.service.VendorProductService;

@Service
@Transactional
public class VendorProductServiceImpl implements VendorProductService{

	@Override
	public Products getProductById(int pId) {
		// TODO Auto-generated method stub
		return getProductById(pId);
	}

	@Override
	public List<Products> getAllProducts(int id) {
		
		return  getAllProducts(id);
	}

	@Override
	public boolean add(VendorProduct vObj) {
		// TODO Auto-generated method stub
		return add(vObj);
	}

	@Override
	public VendorProduct checkProductForVendor(int vendorId, int productId) {
		// TODO Auto-generated method stub
		return checkProductForVendor(vendorId, productId);
	}

}
