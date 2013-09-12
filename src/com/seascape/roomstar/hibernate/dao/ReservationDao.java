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

import com.seascape.roomstar.domain.Reservation;

public class ReservationDao {

	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(ReservationDao.class.getName());
	private static Session session;
	
	public ReservationDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	
	public List listReservations() {
		LOGGER.setLevel(Level.INFO);
	    List<Reservation> list = new ArrayList<Reservation>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM Reservation").list();                       
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
	
	/* Method to INSERT Reservation */
	public Long addReservation(Reservation obj){
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
	

	/* Method to UPDATE Reservation */
	public void updateReservation(Reservation obj){
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
	
	/* Method to DELETE Reservation */
	public void deleteReservation(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Reservation obj =
			(Reservation)session.get(Reservation.class, key);
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
