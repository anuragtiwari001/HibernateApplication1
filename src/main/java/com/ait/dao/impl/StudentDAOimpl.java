package com.ait.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.ait.dao.StudentDAO;
import com.ait.entity.Student;


public class StudentDAOimpl implements StudentDAO {
	SessionFactory factory;
	
	public StudentDAOimpl(){
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		factory = metadata.getSessionFactoryBuilder().build();
	}
	
	
//	@SuppressWarnings("deprecation")
	@Override
	public void saveStudent(Student student){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
//			session.save(student);
			session. persist(student);
			System.out.println("Student object is persisted in Database");
			t.commit();
		}
		catch(Exception ex){
			t.rollback();
			System.out.println("Issue is persisting Student object....");
			System.out.println(ex);
//			ex.printStackTrace();
		}
		finally {
			session.close();
		}
	}


	@SuppressWarnings("deprecation")
	@Override
	public Student loadStudent(int sid) {
		Session session = factory.openSession();
		Student stu = session.get(Student.class, sid);
	//	Student stu = session.load(Student.class, sid);
		try {
			Thread.sleep(30000);
		}
		catch(Exception e) {
			
		}
		System.out.println("Name of Student: "+ stu.getSname());
//		System.out.println("Student [sid=" + stu.getSid() +", sname=" + stu.getSname() +", gender=" + stu.getGender() +", marks=" + stu.getMarks() + "]");
		session.close();
		return stu;
	}
}



/*
 * 	load(): lazy loading 
 *  get(): early loading 
 *  If you want to call load() and get() methods you have to pass 2 arguments
 *  args: 1- classname.class
 *  	  2- id value
*/

