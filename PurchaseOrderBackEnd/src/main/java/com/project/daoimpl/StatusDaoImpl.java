package com.project.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.daos.StatusDao;
import com.project.models.Status;

@Repository("StatusDao")
@Transactional
public class StatusDaoImpl implements StatusDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addStatus(Status statusObj) {
			try {
				Session session = sessionFactory.getCurrentSession();
				
				session.saveOrUpdate(statusObj);
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	

	@Override
	public List<Status> viewStatus() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from com.project.models.Status where status_id =911");
			List<Status> StatusList = q.list();
			return StatusList;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
	}


	@Override
	public boolean updateStatus(String statusName) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query = session.createQuery("update com.project.models.Status set status_name=:x where id=911");
			query.setParameter("x", statusName);
			int result = query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	return false;
	}

}
