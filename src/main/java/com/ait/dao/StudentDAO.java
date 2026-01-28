package com.ait.dao;

import com.ait.entity.Student;

public interface StudentDAO {
	abstract void saveStudent(Student student);
	Student loadStudent(int sid);
	
}
