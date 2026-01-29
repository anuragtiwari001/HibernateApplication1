package com.ait.dao;

import com.ait.entity.Student;

public interface StudentDAO {
	abstract void saveStudent(Student student);
	abstract Student loadStudent(int sid);
	abstract Student updateStudent (int sid , int marks);
	abstract void deleteStudent(int sid);
}
