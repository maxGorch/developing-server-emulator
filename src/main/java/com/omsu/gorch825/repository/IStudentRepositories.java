package com.omsu.gorch825.repository;

import com.omsu.gorch825.models.Student.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepositories extends JpaRepository<StudentEntity, Long> {
}
