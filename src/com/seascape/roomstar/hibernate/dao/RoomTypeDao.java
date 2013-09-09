package com.seascape.roomstar.hibernate.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.app.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.seascape.roomstar.domain.RoomType;

public class RoomTypeDao {

	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(RoomTypeDao.class.getName());

	/*
	public RoomTypeDao() {
		try{
			factory = new Configuration().configure().buildSessionFactory();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}*/
	
	
	public List listRoomTypes() {
		LOGGER.setLevel(Level.INFO);
	    List<RoomType> list = new ArrayList<RoomType>();
	    //Session session = factory.openSession();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM RoomType").list();                       
        	for (Iterator iterator =
        			list.iterator(); iterator.hasNext();){
        			RoomType type = (RoomType) iterator.next();
                                System.out.println("roomType="+type.getName());
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
	/* Method to READ all the types 
	public List listRoomTypes( ){
	LOGGER.setLevel(Level.SEVERE);
	Session session = factory.openSession();
	Transaction tx = null;
	List list = null;
	try{
	tx = session.beginTransaction();
	list = session.createQuery("FROM RoomType").list();
	for (Iterator iterator =
	list.iterator(); iterator.hasNext();){
	RoomType type = (RoomType) iterator.next();
	}
	tx.commit();
	}catch (HibernateException e) {
	if (tx!=null) tx.rollback();
	e.printStackTrace();
	}finally {
	session.close();
	}
	
	return list;
	}*/
	
	
	/* Method to INSERT RoomType */
	public Long addRoomType(RoomType obj){
		Session session = factory.openSession();
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
	

	/* Method to UPDATE RoomType */
	public void updateRoomType(RoomType obj){
		Session session = factory.openSession();
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
	
	/* Method to DELETE RoomType */
	public void deleteRoomType(Integer key){
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			RoomType obj =
			(RoomType)session.get(RoomType.class, key);
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