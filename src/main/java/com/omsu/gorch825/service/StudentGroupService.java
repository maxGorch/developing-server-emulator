package com.omsu.gorch825.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.omsu.gorch825.dto.Request.StudentGroup.AddStudentGroupRequest;
import com.omsu.gorch825.dto.Request.StudentGroup.EditStudentGroupRequest;
import com.omsu.gorch825.models.StudentGroup.StudentGroupEntity;
import com.omsu.gorch825.repository.IGroupStudentRepositories;
import com.omsu.gorch825.validation.StudentGroup.AddStudentGroupRequestValidator;
import com.omsu.gorch825.validation.StudentGroup.EditStudentGroupRequestValidator;

@Service
public class StudentGroupService {
    private final IGroupStudentRepositories groupRepository;

    private final AddStudentGroupRequestValidator addRequestValidator;
    private final EditStudentGroupRequestValidator editRequestValidator;

    public StudentGroupService(
            IGroupStudentRepositories groupRepository,
            AddStudentGroupRequestValidator addRequestValidator,
            EditStudentGroupRequestValidator editRequestValidator) {
        this.groupRepository = groupRepository;
        this.addRequestValidator = addRequestValidator;
        this.editRequestValidator = editRequestValidator;
    }

    public Long addStudentGroup(AddStudentGroupRequest request) {

        List<String> errors = addRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Ошибка : " + String.join(", ", errors));
        }

        StudentGroupEntity group = new StudentGroupEntity(
                request.getNameGroup());

        return groupRepository.save(group).getId();
    }

    public void editStudentGroup(EditStudentGroupRequest request) {
        List<String> errors = editRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Ошибка : " + String.join(", ", errors));
        }
        StudentGroupEntity group = groupRepository
                .findById(request.getId())
                .orElse(null);

        if (group == null) {
            throw new IllegalArgumentException("Группа с таким id не найдена");
        }

        group.setName(request.getNewNameStudentGroup());
        groupRepository.save(group);
    }

    public void deleteStudentGroup(Long id) {
        groupRepository.deleteById(id);
    }

    public StudentGroupEntity getStudentGroupById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    public List<StudentGroupEntity> getAllStudents() {
        return groupRepository.findAll();
    }
}
