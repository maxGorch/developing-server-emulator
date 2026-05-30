package com.omsu.gorch825.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omsu.gorch825.models.Attendance.AttendanceEntity;

public interface IAttendanceRepository extends JpaRepository<AttendanceEntity, Long> {

}