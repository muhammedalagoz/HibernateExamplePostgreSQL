package com.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Person;
import com.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		SessionFactory hibernateSessionFactory = HibernateUtil.getSessionFactory();
		Session session = hibernateSessionFactory.openSession();
		
		session.beginTransaction();
		
		Person p1 = new Person();
		p1.setFirstName("Muhammed");
		p1.setLastName("Alagöz");
		p1.setAge(27);
		long personId = (Long) session.save(p1);
		
		session.getTransaction().commit();
		
		Person person = (Person) session.get(Person.class, personId);		
		
		System.out.println(person);
				
		session.close();
	}
}