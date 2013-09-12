package com.seascape.roomstar.hibernate.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.seascape.roomstar.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seascape.roomstar.domain.Address;

public class AddressDao {

	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(AddressDao.class.getName());
	private static Session session;
	
	public AddressDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	
	public List listAddresss() {
		LOGGER.setLevel(Level.INFO);
	    List<Address> list = new ArrayList<Address>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM Address").list();                       
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
	
	/* Method to INSERT Address */
	public Long addAddress(Address obj){
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
	

	/* Method to UPDATE Address */
	public void updateAddress(Address obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//Employee employee =
		//(Employee)session.get(Employee.class, EmployeeID);
		//employee.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE Address */
	public void deleteAddress(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Address obj =
			(Address)session.get(Address.class, key);
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
