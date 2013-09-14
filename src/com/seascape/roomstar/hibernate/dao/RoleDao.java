package com.seascape.roomstar.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seascape.roomstar.domain.Role;
import com.seascape.roomstar.hibernate.HibernateUtil;

public class RoleDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(RoleDao.class.getName());
	private static Session session;
	
	public RoleDao() {
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public Role findById(Long id) {
		
		Role Role = (Role) session.get(Role.class, id);
		
		return Role;
	}
	
	public List listRoles() {
		LOGGER.setLevel(Level.INFO);
	    List<Role> list = new ArrayList<Role>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM Role").list();                       
        	tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
	}	
	
	/* Method to INSERT Role */
	public Long addRole(Role obj){
		Transaction tx = null;
		Long key = null;
		try{
		tx = session.beginTransaction();
		key = (Long) session.save(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return key;
		}
	

	/* Method to UPDATE Role */
	public void updateRole(Role obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//Role Role =
		//(Role)session.get(Role.class, RoleID);
		//Role.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE Role */
	public void deleteRole(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Role obj =
			(Role)session.get(Role.class, key);
			session.delete(obj);
			tx.commit();
			}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			}finally {
			session.close();
			}
			}

}


