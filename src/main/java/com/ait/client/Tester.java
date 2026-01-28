package com.ait.client;

import com.ait.dao.StudentDAO;
import com.ait.dao.impl.StudentDAOimpl;
import com.ait.entity.Student;

public class Tester {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAOimpl();
		

//		Student student2 = new Student();
//		student2.setSname("AMITA GOYAL");
//		student2.setSid(88088);
//		student2.setGender("Male");
//		student2.setMarks(500);
//		dao.saveStudent(student2);
//		
//		Student student3 = new Student();
//		student3.setSname("PRABHU ACHARYA");
//		student3.setSid(99099);
//		student3.setGender("Male");
//		student3.setMarks(500);
//		dao.saveStudent(student3);
//		
//		Student student4 = new Student();
//		student4.setSname("PRABHU ACHARYA");
//		student4.setSid(10100);
//		student4.setGender("Male");
//		student4.setMarks(500);
//		dao.saveStudent(student4);
		
		Student stud = dao.loadStudent(11012);
		System.out.println(stud);

	}
}

 




