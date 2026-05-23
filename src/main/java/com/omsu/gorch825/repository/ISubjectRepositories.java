package com.omsu.gorch825.repository;

import com.omsu.gorch825.models.Subject.Subject;
import com.omsu.gorch825.models.Subject.SubjectEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepositories extends JpaRepository<SubjectEntity, Long> {

}
