package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.Repository.StudentRepository;
import com.school.Repository.SubjectRepository;
import com.school.entities.Student;
import com.school.entities.Subject;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student addStudent(Student student) {
        
    	// Save or update associated subjects
    	Set<Subject> savedSubjects = new HashSet<>();

    	for (Subject subject : student.getSubjects()) {
    	    Subject savedSubject = (subject.getId() == 0)
    	        ? subjectRepository.save(subject)
    	        : subjectRepository.findById(subject.getId()).orElse(subject);
    	    savedSubjects.add(savedSubject);
    	}
    	student.setSubjects(savedSubjects);
    	Student savedStudent = studentRepository.save(student);

    	// Update subjects with the saved student
    	for (Subject subject : savedSubjects) {
    	    subject.getStudents().add(savedStudent);
    	    subjectRepository.save(subject);
    	}
    	return savedStudent;
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getSingleStudent(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student) {
        // Find the existing student
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        if (existingStudent == null) return null;

        // Update student details
        existingStudent.setName(student.getName());
        existingStudent.setAddress(student.getAddress());

        // Remove old subjects
        Set<Subject> oldSubjects = existingStudent.getSubjects();
        for (Subject oldSubject : oldSubjects) {
            oldSubject.getStudents().remove(existingStudent);
            subjectRepository.save(oldSubject);
        }

        existingStudent.getSubjects().clear();

        // Add new subjects
        Set<Subject> newSubjects = new HashSet<>();
        for (Subject subject : student.getSubjects()) {
            Subject managedSubject;
            if (subject.getId() == 0) {
                managedSubject = subjectRepository.save(subject);
            } else {
                managedSubject = subjectRepository.findById(subject.getId()).orElse(subjectRepository.save(subject));
            }
            newSubjects.add(managedSubject);
        }
        existingStudent.setSubjects(newSubjects);

        // Update subjects with the updated student
        for (Subject subject : newSubjects) {
            Set<Student> students = subject.getStudents();
            if (students == null) {
                students = new HashSet<>();
                subject.setStudents(students);
            }
            students.add(existingStudent);
            subjectRepository.save(subject);
        }

        // Save the updated student
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(int id) {
        Optional<Student> opt = studentRepository.findById(id);
        if (opt.isPresent()) {
            Student student = opt.get();
            // Remove associated subjects
            for (Subject subject : student.getSubjects()) {
                subject.getStudents().remove(student);
                subjectRepository.save(subject);
            }
            studentRepository.delete(student);
        }
    }
}
