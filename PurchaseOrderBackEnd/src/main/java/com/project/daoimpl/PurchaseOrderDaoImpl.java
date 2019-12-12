package com.project.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.daos.PurchaseOrderDao;
import com.project.models.PurchaseOrder;


@Transactional
@Repository("purchaseOrderDao")
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addPo(PurchaseOrder pObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.persist(pObj);
			return true;	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PurchaseOrder> viewAllPo() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from com.project.models.PurchaseOrder");
			List<PurchaseOrder> purchaseOrder = q.list();
			return purchaseOrder;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
}