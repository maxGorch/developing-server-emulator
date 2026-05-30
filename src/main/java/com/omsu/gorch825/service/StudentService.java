package com.omsu.gorch825.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.omsu.gorch825.dto.Request.Student.AddStudentRequest;
import com.omsu.gorch825.dto.Request.Student.EditStudentRequest;
import com.omsu.gorch825.dto.Response.Student.AddStudentResponse;
import com.omsu.gorch825.dto.Response.Student.EditStudentResponse;
import com.omsu.gorch825.exceptions.NotFoundException;
import com.omsu.gorch825.models.Student.StudentEntity;
import com.omsu.gorch825.models.StudentGroup.StudentGroupEntity;
import com.omsu.gorch825.repository.IGroupStudentRepositories;
import com.omsu.gorch825.repository.IStudentRepositories;

@Service
public class StudentService {
    private final IStudentRepositories studentRepository;
    private final IGroupStudentRepositories groupRepository;

    public StudentService(IStudentRepositories studentRepository, IGroupStudentRepositories groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public AddStudentResponse addStudent(AddStudentRequest request) {
        StudentGroupEntity group = groupRepository.findById(request.getIdStudentGroup())
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND,
                        "Группа с ID " + request.getIdStudentGroup() + " не найдена"));

        StudentEntity student = new StudentEntity(
                request.getFirstName(),
                request.getLastName(),
                request.getMiddleName(),
                group,
                request.getStatus());

        var studentRepo = studentRepository.save(student);

        return new AddStudentResponse(studentRepo.getId(),
                studentRepo.getFirstName(),
                studentRepo.getMiddleName(),
                studentRepo.getLastName(),
                studentRepo.getStatus(),
                group.getName());
    }

    public EditStudentResponse editStudent(EditStudentRequest request, Long id) {

        StudentGroupEntity group = groupRepository.findById(request.getIdStudentGroup())
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND,
                        "Группа с ID " + request.getIdStudentGroup() + " не найдена"));

        StudentEntity studentRepo = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND,
                        "Студент с ID " + id + " не найден"));

        if (studentRepo.getId() != request.getId()) {
            throw new NotFoundException(HttpStatus.NOT_FOUND,
                    "Студент с ID " + request.getId() + " не найден");
        }

        StudentEntity studentToUpdate = new StudentEntity(
                request.getFirstName(),
                request.getLastName(),
                request.getMiddleName(),
                group,
                request.getStatus());

        var studentToUpdateRepo = studentRepository.save(studentToUpdate);

        return new EditStudentResponse(
                studentToUpdateRepo.getId(),
                group.getId(),
                studentToUpdateRepo.getStatus(),
                studentToUpdateRepo.getLastName(),
                studentToUpdateRepo.getMiddleName(),
                studentToUpdateRepo.getFirstName());
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }
}
