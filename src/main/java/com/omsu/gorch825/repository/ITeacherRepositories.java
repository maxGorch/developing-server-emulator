package com.omsu.gorch825.repository;

import com.omsu.gorch825.models.Teacher.Teacher;
import com.omsu.gorch825.models.Teacher.TeacherEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepositories extends JpaRepository<TeacherEntity, Long> {

}
