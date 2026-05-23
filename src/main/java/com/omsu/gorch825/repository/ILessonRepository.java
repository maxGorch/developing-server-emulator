package com.omsu.gorch825.repository;

import com.omsu.gorch825.models.Lesson.Lesson;
import com.omsu.gorch825.models.Lesson.LessonEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ILessonRepository extends JpaRepository<LessonEntity, Long> {

}