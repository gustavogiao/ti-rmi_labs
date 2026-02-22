package pt.estga.ti.rmi.client;

import pt.estga.ti.rmi.entities.Student;
import pt.estga.ti.rmi.interfaces.SchoolManagementRemote;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class SchoolManagementClient {

    public static void main(String[] args) {

        try {

            SchoolManagementRemote service =
                    (SchoolManagementRemote)
                            Naming.lookup("rmi://127.0.0.1/SchoolManagementRemote");

            Scanner scan = new Scanner(System.in);

            while (true) {

                System.out.println("\n===== SCHOOL MANAGEMENT =====");
                System.out.println("1 - List Students");
                System.out.println("2 - Get Student by ID");
                System.out.println("3 - Add Student");
                System.out.println("4 - Update Student");
                System.out.println("5 - Delete Student");
                System.out.println("0 - Exit");
                System.out.print("Option: ");

                if (!scan.hasNextInt()) {
                    System.out.println("Invalid input.");
                    scan.nextLine();
                    continue;
                }

                int option = scan.nextInt();
                scan.nextLine();

                switch (option) {

                    case 1:
                        List<Student> students = service.getAllStudents();

                        if (students.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            for (Student s : students) {
                                System.out.println(
                                        s.getId() + " - " +
                                                s.getName() + " - " +
                                                s.getEmail()
                                );
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Student ID: ");
                        int studentId = scan.nextInt();
                        scan.nextLine();

                        Student student = service.getStudentById(studentId);

                        if (student == null) {
                            System.out.println("Student not found.");
                        } else {
                            System.out.println("ID: " + student.getId());
                            System.out.println("Name: " + student.getName());
                            System.out.println("Age: " + student.getAge());
                            System.out.println("Email: " + student.getEmail());
                            System.out.println("Course ID: " + student.getCourseId());
                        }
                        break;

                    case 3:
                        System.out.print("Name: ");
                        String name = scan.nextLine();

                        System.out.print("Age: ");
                        int age = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Email: ");
                        String email = scan.nextLine();

                        System.out.print("Course ID: ");
                        int courseId = scan.nextInt();
                        scan.nextLine();

                        Student newStudent =
                                new Student(0, name, age, email, courseId);

                        service.addStudent(newStudent);

                        System.out.println("Student added successfully.");
                        break;

                    case 4:
                        System.out.print("Student ID to update: ");
                        int updateId = scan.nextInt();
                        scan.nextLine();

                        System.out.print("New Name: ");
                        String newName = scan.nextLine();

                        System.out.print("New Age: ");
                        int newAge = scan.nextInt();
                        scan.nextLine();

                        System.out.print("New Email: ");
                        String newEmail = scan.nextLine();

                        System.out.print("New Course ID: ");
                        int newCourseId = scan.nextInt();
                        scan.nextLine();

                        Student updatedStudent =
                                new Student(updateId, newName, newAge, newEmail, newCourseId);

                        service.updateStudent(updatedStudent);

                        System.out.println("Student updated successfully.");
                        break;

                    case 5:
                        System.out.print("Student ID to delete: ");
                        int deleteId = scan.nextInt();
                        scan.nextLine();

                        service.deleteStudent(deleteId);

                        System.out.println("Student deleted successfully.");
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            }

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}