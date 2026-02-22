package pt.estga.ti.rmi.entities;

import java.io.Serializable;

public class Course implements Serializable {

    private int id;
    private String name;
    private int durationYears;

    public Course(int id, String name, int durationYears) {
        this.id = id;
        this.name = name;
        this.durationYears = durationYears;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDurationYears() {
        return durationYears;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", durationYears=" + durationYears +
                '}';
    }
}
