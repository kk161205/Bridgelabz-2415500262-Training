package com.jdbc.jdbc;

public class Main {
	public static void main(String[] args) {
        IConnection conn = new ConnectionImpl();
        IStudent studentService = new StudentImpl(conn);
        IMenu menu = new MenuImpl(studentService);

        System.out.println("Welcome to JDBC Student Database System");
        menu.showMenu();
    }
}
