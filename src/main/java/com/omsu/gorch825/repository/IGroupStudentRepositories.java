package com.omsu.gorch825.repository;

import com.omsu.gorch825.models.StudentGroup.StudentGroup;
import com.omsu.gorch825.models.StudentGroup.StudentGroupEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupStudentRepositories extends JpaRepository<StudentGroupEntity, Long> {

}
