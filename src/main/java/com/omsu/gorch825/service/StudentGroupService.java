package com.omsu.gorch825.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.omsu.gorch825.dto.Request.StudentGroup.AddStudentGroupRequest;
import com.omsu.gorch825.dto.Request.StudentGroup.EditStudentGroupRequest;
import com.omsu.gorch825.dto.Response.StudentGroup.AddStudentGroupResponse;
import com.omsu.gorch825.dto.Response.StudentGroup.EditStudentGroupResponse;
import com.omsu.gorch825.exceptions.BadRequestException;
import com.omsu.gorch825.exceptions.NotFoundException;
import com.omsu.gorch825.models.StudentGroup.StudentGroupEntity;
import com.omsu.gorch825.repository.IGroupStudentRepositories;

@Service
public class StudentGroupService {
    private final IGroupStudentRepositories groupRepository;

    public StudentGroupService(IGroupStudentRepositories groupRepository) {
        this.groupRepository = groupRepository;
    }

    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) {
        StudentGroupEntity group = new StudentGroupEntity(
                request.getNameGroup());

        var groupRepos = groupRepository.save(group);
        var response = new AddStudentGroupResponse(
                groupRepos.getId(),
                groupRepos.getName());
        return response;
    }

    public EditStudentGroupResponse editStudentGroup(EditStudentGroupRequest request, Long id) {
        if (!id.equals(request.getId())) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "id в пути и в теле запроса должны быть одинаковыми");
        }
        StudentGroupEntity group = groupRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND,
                        "Группа с таким id" + request.getId() + " не найдена"));

        group.setName(request.getNewNameStudentGroup());

        var groupRepos = groupRepository.save(group);
        var response = new EditStudentGroupResponse(
                groupRepos.getId(),
                groupRepos.getName());
        return response;
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
