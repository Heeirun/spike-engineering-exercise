package com.example.spike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
@RestController
public class SpikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpikeApplication.class, args);
	}

	// // LOGIN PAGE
	// @RequestMapping(value = "/user/credentials", method = RequestMethod.GET)
	// public ResponseEntity<String> getCredentials(@RequestParam(value="credentials", defaultValue= "nocreds") String credentials) {
	// 	if (credentials.equals("nocreds")){
	// 		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	// 	}

	// 	SessionFactory sessFact = null;

	// 	try {
	// 		sessFact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	// 	} catch (Throwable ex) { 
	// 		System.err.println("Failed to create sessionFactory object." + ex);
	// 		throw new ExceptionInInitializerError(ex); 
	// 	}

		
	// 	Session session = sessFact.openSession();
	// 	Transaction transx = null;
	// 	List<User> users = new ArrayList<User>();
	// 	String[] tokens = credentials.split("_");
	// 	String username = tokens[0];
	// 	String password = tokens[1];
	// 	System.out.println("Username: " + username);
	// 	System.out.println("Pass: " + password);
	// 	String returnedUsername = "";
	// 	String returnedPassword = "";
	// 	try {
	// 		transx = session.beginTransaction();
	// 		Query<User> query = session.createQuery("from userInfo where username = :username and password = :password", User.class);
	// 		query.setParameter("username", username);
	// 		query.setParameter("password", password);
	// 		users = query.getResultList();
	// 		if (users.size() == 1) {
	// 			returnedUsername = users.get(0).getUsername();
	// 			returnedPassword = users.get(0).getPassword();
	// 		} else {
	// 			System.out.println("This shouldnt be here!");
	// 			transx.commit();
	// 			session.close();
	// 			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	// 		}
	// 	} catch (HibernateException e) {
	// 		if (transx!=null) {transx.rollback();}
	// 		e.printStackTrace(); 
	// 	} finally {
	// 		session.close();
	// 	}
	// 	// query and see if both username and password exists
	// 	// if exist return OK(200) else return NO_CONTENT(204)
	// 	if (username.equals(returnedUsername) && password.equals(returnedPassword)) {
	// 		return ResponseEntity.status(HttpStatus.OK).build();
	// 	} else {
	// 		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	// 	}
	// }

	// MAIN PAGE
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getUser(@RequestParam(value = "id", defaultValue = "100") String id) {
		// query in DB here if user exits, if so return OK(200) else return NO_CONTENT(204)
		// SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
		// Session session = sessFact.openSession();
		// Transaction transx = null;
		// List<User> users = new ArrayList<User>();
		// System.out.println("Set up this !");
		// try{
		// 	transx = session.beginTransaction();
		// 	Query<User> query = session.createQuery("from userInfo where id = :id", User.class);
		// 	query.setParameter("id", id);
		// 	users = query.getResultList();
		// } catch (HibernateException e) {
		// 	if (transx!=null) {transx.rollback();}
		// 	e.printStackTrace(); 
		// } finally {
		// 	session.close();
		// }
		// return users.get(0);
		return new User(new Integer(id), "I like meeting new people!", "CS640, CS 506", "The sky is the limit", "Sports and Friends", "other", "linkedin", "Heeirun", "password");
	}

}
