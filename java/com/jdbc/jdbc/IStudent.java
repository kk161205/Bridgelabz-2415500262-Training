package com.jdbc.jdbc;

import java.util.List;

public interface IStudent {
	void insertStudent(Student s);
    void insertMultipleStudents(List<Student> students);
    void updateStudent(Student s);
    void updateMultipleStudents(List<Student> students);
    void deleteStudent(int id);
    void deleteMultipleStudents(List<Integer> ids);
    List<Student> getAllStudents();
}
