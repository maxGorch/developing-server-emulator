package com.omsu.gorch825.repository;

import com.omsu.gorch825.models.Teacher.TeacherEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepositories extends JpaRepository<TeacherEntity, Long> {

}
