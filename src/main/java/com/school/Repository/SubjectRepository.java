package com.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}