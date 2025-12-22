package com.omsu.gorch825.repository;

import com.omsu.gorch825.models.Lesson.Lesson;
import java.util.List;

public interface ILessonRepository {
    /*
        Написать набор интерфейсов репозиториев (хранилищ данных) для сущностей из п.1.
        Каждый репозиторий предоставляет набор методов (возможны дополнительные методы):

        добавление сущности в репозиторий (на входе сущность с id = null, сущность добавляется в
        хранилище, при этом ей назначается значение id, этот id возвращается как результат),

        редактирование существующей сущности (на входе сущность с непустым id, входная
        сущность подменяет старую),

         удаление сущности по id,
         получение сущности по id,

        Репозиторий занятий вместо метода получения всех занятий содержит:

         получение всех занятий по id преподавателя за заданный промежуток дат,
         получение всех занятий по id группы за заданный промежуток дат,
         удаление всех занятий по id преподавателя,
         удаление всех занятий по id группы.

        Репозиторий занятий не работает с данными о посещаемости.
    */
    /**
     * @addEntity — добавление сущности занятия в репозиторий
     * @Entity — на входе сущность с id = null, сущность добавляется в хранилище,
     *            при этом ей назначается значение id,
     *            этот id возвращается как результат
     */
    Long addLesson(Lesson lesson);
    /**
     * @editEntity — редактирование существующей сущности занятия
     * @Entity — на входе сущность с непустым id,
     *           входная сущность подменяет старую
     */
    void editLesson(Lesson lesson);
    /**
     * @deleteEntity — удаление сущности занятия по id
     * @id — id сущности занятия
     */
    void deleteLesson(Long id);
    /**
     * @getEntityById — получение сущности занятия по id
     * @id — id сущности занятия
     * @return объект занятия
     */
    Lesson getLessonById(Long id);

    /**
     * @getEntityByTeacher — получение всех занятий по id преподавателя
     *                        за заданный промежуток дат
     * @teacherId — id преподавателя
     * @startDate — дата начала периода
     * @endDate — дата окончания периода
     * @return список занятий
     */
    List<Lesson> getLessonsByTeacher(Long teacherId, String startDate, String endDate);
    /**
     * @getEntityByGroup — получение всех занятий по id группы
     *                      за заданный промежуток дат
     * @groupId — id группы
     * @startDate — дата начала периода
     * @endDate — дата окончания периода
     * @return список занятий
     */
    List<Lesson> getLessonsByGroup(Long groupId, String startDate, String endDate);

    /**
     * @deleteEntityByTeacher — удаление всех занятий по id преподавателя
     * @teacherId — id преподавателя
     */
    void deleteLessonsByTeacher(Long teacherId);
    /**
     * @deleteEntityByGroup — удаление всех занятий по id группы
     * @groupId — id группы
     */
    void deleteLessonsByGroup(Long groupId);
}