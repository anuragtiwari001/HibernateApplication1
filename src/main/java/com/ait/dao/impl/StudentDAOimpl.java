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
			System.out.println("Issue in persisting Student object....");
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

	@SuppressWarnings("deprecation")
	@Override
	public Student updateStudent(int sid, int marks) {
		Session session = factory.openSession();
		Student s = session.get(Student.class, sid);
		Transaction t = session.beginTransaction();
		try {
			s.setMarks(marks);
//			session.update(s); Deprecated Method from version 6
			session.merge(s);
			t.commit();
			System.out.println("Object is updated....");
		}
		catch(Exception Ex){
			t.rollback();
			System.out.println("Object is not Updated....");
		}
		finally {
			session.close();
		}
		return s;
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public void deleteStudent(int sid) {
		Session session = factory.openSession();
		Student s = session.get(Student.class, sid);
		Transaction t = session.beginTransaction();
		try {
//			session.delete(t);// Deprecated method from version 6
			session.remove(s);
			System.out.println("Object Deleted Successfully");
			t.commit();
		}
		catch(Exception Ex) {
			t.rollback();
			System.out.println("Object is not Deleted....");
		}
	}
}


/*
 * 	load(): lazy loading 
 *  get(): early loading 
 *  If you want to call load() and get() methods you have to pass 2 arguments
 *  args: 1- classname.class
 *  	  2- id value
 *  
 *  
 *  git status
	git add .
	git commit -m "Added update operation using Hibernate"
	git push

*/

