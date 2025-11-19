package com.jdbc.jdbc;

import java.util.*;


public class MenuImpl implements IMenu{
	private final Scanner sc = new Scanner(System.in);
	    private final IStudent studentService;

	    public MenuImpl(IStudent studentService) {
	        this.studentService = studentService;
	    }

	    @Override
	    public void showMenu() {
	        while (true) {
	            System.out.println("\n===== Student Database Menu =====");
	            System.out.println("1. Insert a student");
	            System.out.println("2. Insert Multiple Students");
	            System.out.println("3. Update a student");
	            System.out.println("4. Update multiple students");
	            System.out.println("5. Delete a student");
	            System.out.println("6. Delete multiple students");
	            System.out.println("7. Show Students");
	            System.out.println("8. Exit");
	            System.out.print("Choose an option: ");

	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1 : 
	                	insertOne();
	                	break;
	                case 2 : 
	                	insertMultiple();
	                	break;
	                case 3 : 
	                	updateOne();
	                	break;
	                case 4 : 
	                	updateMultiple();
	                	break;
	                case 5 : 
	                	deleteOne();
	                	break;
	                case 6 : 
	                	deleteMultiple();
	                	break;
	                case 7 : 
	                	showAll();
	                	break;
	                case 8 : {
	                    System.out.println("👋 Exiting...");
	                    return;
	                }
	                default : 
	                	System.out.println("Invalid option!");
	                	break;
	            }
	        }
	    }

	    private void insertOne() {
	        Student s = getStudentInput();
	        studentService.insertStudent(s);
	    }

	    private void insertMultiple() {
	        System.out.print("Enter number of students: ");
	        int n = sc.nextInt(); sc.nextLine();
	        List<Student> list = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            System.out.println("Student " + (i + 1) + ":");
	            list.add(getStudentInput());
	        }
	        studentService.insertMultipleStudents(list);
	    }

	    private void updateOne() {
	        Student s = getStudentInput();
	        studentService.updateStudent(s);
	    }

	    private void updateMultiple() {
	        System.out.print("Enter number of students to update: ");
	        int n = sc.nextInt(); sc.nextLine();
	        List<Student> list = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            System.out.println("Student " + (i + 1) + ":");
	            list.add(getStudentInput());
	        }
	        studentService.updateMultipleStudents(list);
	    }

	    private void deleteOne() {
	        System.out.print("Enter student ID: ");
	        int id = sc.nextInt();
	        studentService.deleteStudent(id);
	    }

	    private void deleteMultiple() {
	        System.out.print("Enter number of students to delete: ");
	        int n = sc.nextInt();
	        List<Integer> ids = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            System.out.print("Enter ID " + (i + 1) + ": ");
	            ids.add(sc.nextInt());
	        }
	        studentService.deleteMultipleStudents(ids);
	    }

	    private void showAll() {
	        List<Student> list = studentService.getAllStudents();
	        list.forEach(System.out::println);
	    }

	    private Student getStudentInput() {
	        System.out.print("ID: ");
	        int id = sc.nextInt(); sc.nextLine();
	        System.out.print("Name: ");
	        String name = sc.nextLine();
	        System.out.print("Age: ");
	        int age = sc.nextInt(); sc.nextLine();
	        System.out.print("Course: ");
	        String course = sc.nextLine();
	        return new Student(id, name, age, course);
	    }
}
