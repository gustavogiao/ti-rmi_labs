package pt.estga.ti.rmi.server.dao;

import pt.estga.ti.rmi.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT id, name, age, email, course_id FROM students";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getInt("course_id")
                );

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getStudentById(int id){

        List<Student> students;

        students = getAllStudents();

        for(Student student : students){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    public void addStudent(Student student) {

        String sql = "INSERT INTO students (name, age, email, course_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getEmail());
            stmt.setInt(4, student.getCourseId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student){

        String sql = "UPDATE students SET name = ?, age = ?, email = ?, course_id = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getEmail());
            stmt.setInt(4, student.getCourseId());
            stmt.setInt(5, student.getId());

            int rows = stmt.executeUpdate();

            if(rows == 0){
                System.out.println("No student found with that ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
