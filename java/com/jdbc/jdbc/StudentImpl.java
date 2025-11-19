package com.jdbc.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentImpl implements IStudent{
	private final Connection conn;

    public StudentImpl(IConnection connection) {
        this.conn = connection.getConnection();
    }

    @Override
    public void insertStudent(Student s) {
        String sql = "INSERT INTO students (id, name, age, course) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getCourse());
            ps.executeUpdate();
            System.out.println("✅ Student inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertMultipleStudents(List<Student> students) {
        for (Student s : students) {
            insertStudent(s);
        }
    }

    @Override
    public void updateStudent(Student s) {
        String sql = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getId());
            ps.executeUpdate();
            System.out.println("✅ Student updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMultipleStudents(List<Student> students) {
        for (Student s : students) {
            updateStudent(s);
        }
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Student deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMultipleStudents(List<Integer> ids) {
        for (int id : ids) {
            deleteStudent(id);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
}
