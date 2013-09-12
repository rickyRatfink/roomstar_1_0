package com.seascape.roomstar.hibernate.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seascape.roomstar.domain.Customer;
import com.seascape.roomstar.hibernate.HibernateUtil;

public class CustomerDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(CustomerDao.class.getName());
	private static Session session;
	
	public CustomerDao() {
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	
	public List listCustomers() {
		LOGGER.setLevel(Level.INFO);
	    List<Customer> list = new ArrayList<Customer>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM Customer").list();                       
        	for (Iterator iterator =
        			list.iterator(); iterator.hasNext();){
        			Customer obj = (Customer) iterator.next();
                                System.out.println("Customer="+obj.getFirstname());
        			}
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
	
	/* Method to INSERT Customer */
	public Long addCustomer(Customer obj){
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
	

	/* Method to UPDATE Customer */
	public void updateCustomer(Customer obj){
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
	
	/* Method to DELETE Customer */
	public void deleteCustomer(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Customer obj =
			(Customer)session.get(Customer.class, key);
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


