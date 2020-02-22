package com.cs506.spike.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.cs506.spike.Models.User;

public class UserDAO
{
	private SessionFactory sessFact;
	
	/*
	 * This object handles queries to the database.
	 */
	public UserDAO() 
	{
		try {
			this.sessFact = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}
	}

	public User getUserByCredentials(User user)
	{
		Session session = sessFact.openSession();
		Transaction tx = null;
		List<User> users = new ArrayList<User>();
		
		try {
			tx = session.beginTransaction();
			Query<User> query = session.createQuery("from User where userName = :userName and password = :password", User.class);
			query.setParameter("userName", user.getUserName());
			query.setParameter("password", user.getPassword());
			users = query.getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) {tx.rollback();}
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		return (users.isEmpty()) ? null : users.get(0);
	}

	public User getUserByID(User user)
	{
		Session session = sessFact.openSession();
		Transaction tx = null;
		List<User> users = new ArrayList<User>();
		
		try {
			tx = session.beginTransaction();
			Query<User> query = session.createQuery("from User where userID = :userID", User.class);
			query.setParameter("userID", user.getUserID());
			users = query.getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) {tx.rollback();}
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		return (users.isEmpty()) ? null : users.get(0);
	}

	public List<User> getAllUsers()
	{
		Session session = sessFact.openSession();
		Transaction tx = null;
		List<User> users = new ArrayList<User>();
		
		try {
			tx = session.beginTransaction();
			users = session.createQuery("from User", User.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) {tx.rollback();}
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		return users;
	}

	public User saveUser(User newUser)
	{
		Session session = sessFact.openSession();
		Transaction tx = null;
		int newUID = 0;
		
		try {
			tx = session.beginTransaction();
			newUID = (int) session.save(newUser); 
			tx.commit();
			newUser.setUserID(newUID);
		} catch (HibernateException e) {
			if (tx!=null) {tx.rollback();}
			e.printStackTrace(); 
		} finally {
			session.close();
		}
			
		return newUser;
	}

	public User updateUser(User updatedUser)
	{
		Session session = sessFact.openSession();
		Transaction tx = null;
		User returnUser = updatedUser;
		
		try {
			tx = session.beginTransaction();
			session.update(updatedUser);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) {tx.rollback();}
			returnUser = null;
			e.printStackTrace(); 
		} finally {
			session.close();
		}
			
		return returnUser;
	}
}