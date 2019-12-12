package com.project.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.daos.POItemsDao;
import com.project.models.POItems;
import com.project.models.Products;

@Repository("POItemsDao")
@Transactional
public class POItemsDaoImpl implements POItemsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<POItems> getLineItemsById(int purchaseOrderId) {
		try {
			
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from com.project.models.POItems where PURCHASEORDERID=:x");
			q.setParameter("x", purchaseOrderId);
			List<POItems> poiList = q.list();
			return poiList;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
}


}
