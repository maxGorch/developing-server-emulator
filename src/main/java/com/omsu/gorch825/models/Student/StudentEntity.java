package com.omsu.gorch825.models.Student;

import com.omsu.gorch825.models.Enums.StudentStatus;
import com.omsu.gorch825.models.Primitives.AuditableEntity;
import com.omsu.gorch825.models.StudentGroup.StudentGroupEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "middle_name", nullable = false, length = 100)
    private String middleName;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private StudentGroupEntity group; // Ссылка на группу

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 50)
    private StudentStatus status;

    public StudentEntity() {

    }

    public StudentEntity(String firstName, String lastName, String middleName, StudentGroupEntity group,
            StudentStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.group = group;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public StudentGroupEntity getGroup() {
        return this.group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public StudentStatus getStatus() {
        return status;
    }
}
