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

import com.seascape.roomstar.domain.Employee;
import com.seascape.roomstar.hibernate.HibernateUtil;

public class EmployeeDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(EmployeeDao.class.getName());
	private static Session session;
	
	public EmployeeDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public Employee findById(Long id) {
		
		Employee employee = (Employee) session.get(Employee.class, id);
		
		return employee;
	}
	
	public Employee authenticate(String username, String password) {
		Query q = session.createQuery("from Employee where username = :username and password = :password");
		q.setString("username", username);
		q.setString("password", password);
		
		List result = q.list();
		if (result.size()>0)
			return (Employee)result.get(0);
		else 
			return null;
	}
	
	public List listEmployees() {
		LOGGER.setLevel(Level.INFO);
	    List<Employee> list = new ArrayList<Employee>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM Employee").list();                       
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
	
	/* Method to INSERT Employee */
	public Long addEmployee(Employee obj){
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
	

	/* Method to UPDATE Employee */
	public void updateEmployee(Employee obj){
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
	
	/* Method to DELETE Employee */
	public void deleteEmployee(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Employee obj =
			(Employee)session.get(Employee.class, key);
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


