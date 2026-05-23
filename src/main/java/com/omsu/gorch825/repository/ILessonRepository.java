package com.omsu.gorch825.repository;

import com.omsu.gorch825.models.Lesson.LessonEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ILessonRepository extends JpaRepository<LessonEntity, Long> {

}