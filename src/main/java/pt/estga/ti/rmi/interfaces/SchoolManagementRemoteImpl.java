package pt.estga.ti.rmi.interfaces;

import pt.estga.ti.rmi.entities.Student;
import pt.estga.ti.rmi.server.dao.StudentDAO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SchoolManagementRemoteImpl extends UnicastRemoteObject implements SchoolManagementRemote {

    private StudentDAO studentDAO = new StudentDAO();

    public SchoolManagementRemoteImpl() throws RemoteException {}

    @Override
    public List<Student> getAllStudents() throws RemoteException {
        return studentDAO.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) throws RemoteException {
        return studentDAO.getStudentById(id);
    }

    @Override
    public void addStudent(Student student) throws RemoteException {
        studentDAO.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) throws RemoteException {
        studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) throws RemoteException {
        studentDAO.deleteStudent(id);
    }
}
