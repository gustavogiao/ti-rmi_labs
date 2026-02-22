package pt.estga.ti.rmi.entities;

import java.io.Serializable;

public class Enrollment implements Serializable {

    private int studentId;
    private int subjectId;
    private Double grade;

    public Enrollment(int studentId, int subjectId, Double grade) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public Double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "studentId=" + studentId +
                ", subjectId=" + subjectId +
                ", grade=" + grade +
                '}';
    }
}
