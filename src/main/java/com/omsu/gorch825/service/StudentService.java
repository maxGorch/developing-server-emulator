package com.omsu.gorch825.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.omsu.gorch825.dto.Request.Student.AddStudentRequest;
import com.omsu.gorch825.models.Student.StudentEntity;
import com.omsu.gorch825.models.StudentGroup.StudentGroupEntity;
import com.omsu.gorch825.repository.IGroupStudentRepositories;
import com.omsu.gorch825.repository.IStudentRepositories;
import com.omsu.gorch825.validation.Student.AddStudentRequestValidator;

@Service
public class StudentService {
    private final IStudentRepositories studentRepository;
    private final IGroupStudentRepositories groupRepository;

    private final AddStudentRequestValidator addRequestValidator;

    public StudentService(IStudentRepositories studentRepository, IGroupStudentRepositories groupRepository,
            AddStudentRequestValidator addRequestValidator) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.addRequestValidator = addRequestValidator;
    }

    public Long addStudent(AddStudentRequest request) {

        List<String> errors = addRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Ошибка : " + String.join(", ", errors));
        }

        StudentGroupEntity group = groupRepository.findById(request.getIdStudentGroup())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Группа с ID " + request.getIdStudentGroup() + " не найдена"));

        StudentEntity student = new StudentEntity(
                request.getFirstName(),
                request.getLastName(),
                request.getMiddleName(),
                group,
                request.getStatus());

        return studentRepository.save(student).getId();
    }

    public void editStudent(StudentEntity student) {

        studentRepository.save(student);
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
