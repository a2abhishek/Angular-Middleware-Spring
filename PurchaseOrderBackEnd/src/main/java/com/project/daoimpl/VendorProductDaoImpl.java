package com.project.daoimpl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.daos.VendorProductDao;
import com.project.models.Products;
import com.project.models.VendorProduct;


@Repository("vendorProductDao")
@Transactional
public class VendorProductDaoImpl implements VendorProductDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public Products getProductById(int pId) {
		try {

			Session session=sessionFactory.getCurrentSession();

			Products pro=session.get(Products.class,pId);

			return pro;

			}

			catch(Exception e){

				e.printStackTrace();

			}

			return null;
	}

	public List<Products> getAllProducts(int id) {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query query=session.createQuery("from com.project.models.VendorProduct where vendorId="+id);

			return query.list();
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		
		return null;
	}

	public boolean add(VendorProduct vObj) {
		
		try {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(vObj);
			System.out.println(vObj+" ");
			return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
	}

	public VendorProduct checkProductForVendor(int vendorId, int productId) {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query query=session.createQuery("from com.project.models.VendorProduct where vendorId=:x and productId=:y");
			query.setParameter("x",vendorId);
			query.setParameter("y",productId);
			List list=query.list();
			if(list.size()!=0) {
				return (VendorProduct) list.get(0);
			}
			}

			catch(Exception e){

				e.printStackTrace();

			}

			

		return null;
	}


}