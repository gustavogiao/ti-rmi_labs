package pt.estga.ti.rmi.interfaces;

import pt.estga.ti.rmi.entities.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SchoolManagementRemote extends Remote {
    List<Student> getAllStudents() throws RemoteException;
    Student getStudentById(int id) throws RemoteException;
    void addStudent(Student student) throws RemoteException;
    void updateStudent(Student student) throws RemoteException;
    void deleteStudent(int id) throws RemoteException;
}
