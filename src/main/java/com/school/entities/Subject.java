package com.school.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "subjects")
    @JsonBackReference
    private Set<Student> students = new HashSet<>();

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    // Constructors
    public Subject(int id, String name, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students != null ? students : new HashSet<>();
    }

    public Subject() {
        this.students = new HashSet<>();
    }

    // toString method
    @Override
    public String toString() {
        return "Subject [id=" + id + ", name=" + name + ", students=" + students + "]";
    }
}
