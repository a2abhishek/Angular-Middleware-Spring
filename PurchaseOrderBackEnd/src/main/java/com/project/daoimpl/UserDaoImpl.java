package com.project.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.daos.UserDao;
import com.project.models.User;

@Repository("UserDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(User userObj) {
			try {
				Session session = sessionFactory.getCurrentSession();
				
				session.saveOrUpdate(userObj);
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public List<User> viewAllUser() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from com.project.models.User");
			List<User> UserList = q.list();
			return UserList;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
	}
	
    @Override
    public boolean deleteUser(User UserObj) {
                    try {
                                    Session session = sessionFactory.getCurrentSession();
                                    session.delete(UserObj);
                                    return true;
                    } catch (Exception e) {
                                    e.printStackTrace();

                    }

                    return false;
    }
    @Override
    public boolean updateUser(User UserObj) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(UserObj);
            return true;
        }
        catch (Exception e) {
        	e.printStackTrace();

        }

        return false;
    }

    @Override
    public User getUserByName(String userName) {
        try {
            Session session=sessionFactory.getCurrentSession();
            User pro=session.get(User.class,userName);
            return pro;
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        return null;
    }

	@Override
	public User getUserByRole(String role) {
		 try {
	            Session session=sessionFactory.getCurrentSession();
	            User pro=session.get(User.class,role);
	            return pro;
	            }
	            catch(Exception e) {
	                e.printStackTrace();
	            }
		return null;
	}
	
	@Override
	public User validateUser(String email, String password) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from com.project.models.User where User_Email=:email and User_password=:password");
			query.setParameter("email", email);
			query.setParameter("password",password);
			
			List<User> list = query.list();
			if(list.size()==0)
			{
				session.close();
			}
			else
			{
				if(list.size()!=0)
				{
					return list.get(0);
				}
			}}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public User getSeller() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from com.project.models.User where role='Seller'");
			List<User>list=query.list();	
			if(list==null) {
			session.close();
		}
		else {
			if(list.size()!=0) {	
				return list.get(0);
			}
		}
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User getBuyer(int id) {
		
		try {

			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from com.project.models.User where role='Buyer' and userId="+id);
			
				List<User>list=query.list();	
			
			if(list.size()!=0)
			{
				
				return list.get(0);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
