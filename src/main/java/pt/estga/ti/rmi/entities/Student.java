package pt.estga.ti.rmi.entities;

import java.io.Serializable;

public class Student implements Serializable {

    private int id;
    private String name;
    private int age;
    private String email;
    private int courseId;

    public Student(int id, String name, int age, String email, int courseId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
