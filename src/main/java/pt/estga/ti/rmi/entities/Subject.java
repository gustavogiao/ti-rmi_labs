package pt.estga.ti.rmi.entities;

import java.io.Serializable;

public class Subject implements Serializable {

    private int id;
    private String name;
    private int ects;
    private int courseId;

    public Subject(int id, String name, int ects, int courseId) {
        this.id = id;
        this.name = name;
        this.ects = ects;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEcts() {
        return ects;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ects=" + ects +
                ", courseId=" + courseId +
                '}';
    }
}
