package com.omsu.gorch825.repository;

import com.omsu.gorch825.models.Attendance.Attendance;

public interface IAttendanceRepository {
    /*
        Написать набор интерфейсов репозиториев (хранилищ данных) для сущностей из п.1.
        Каждый репозиторий предоставляет набор методов (возможны дополнительные методы):

        Репозиторий посещаемости содержит методы:
         добавить данные о посещаемости для занятия по id занятия,
         удалить данные о посещаемости по id занятия
    */
    /**
     * @addAttendance — добавление данных о посещаемости для занятия
     * @lessonId — id занятия, к которому относится посещаемость
     * @attendance — объект посещаемости,
     *               добавляется в хранилище для указанного занятия
     */
    void addAttendance(Long lessonId, Attendance attendance);
    /**
     * @deleteAttendance — удаление данных о посещаемости по id занятия
     * @lessonId — id занятия
     */
    void deleteAttendance(Long lessonId);

}