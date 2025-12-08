package com.omsu.gorch825.repositories;

import com.omsu.gorch825.view.StudentGroup.StudentGroup;

import java.util.List;

public interface IGroupStudentRepositories {
    /*
        Написать набор интерфейсов репозиториев (хранилищ данных) для сущностей из п.1.
        Каждый репозиторий предоставляет набор методов (возможны дополнительные методы):

        добавление сущности в репозиторий (на входе сущность с id = null, сущность добавляется в
        хранилище, при этом ей назначается значение id, этот id возвращается как результат),

        редактирование существующей сущности (на входе сущность с непустым id, входная
        сущность подменяет старую),

         удаление сущности по id,
         получение сущности по id,
         получение всех сущностей.
    */
    /**
     * @addEntity - добавляемая сущность в репозиторий и возвращает id этой сущности как результат
     * @model - на входе сущность с id = null, сущность добавляется в хранилище,
     * при этом ей назначается значение id, этот id возвращается как результат)
     * */
    Long addStudentGroup(StudentGroup model);

    /**
     * @editGroupStudent - редактирование существующей сущности
     * @model - на входе сущность с непустым id, входная
     *         сущность подменяет старую
     * */
    void editStudentGroup(StudentGroup model);

    /**
     * @deleteEntity - удаление сущности по id;
     * @idEntity - id  сущности
     * */
    void deleteStudentGroup(Long idEntity);

    /**
     * @getEntityById - получение сущности по id и возвращает объект этой сущности как результат;
     * @idEntity - id  сущности
     * */
    StudentGroup getStudentGroupById(Long idEntity);

    /**
     * @getAllEntity - получение всех сущностей;
     * */
    List<StudentGroup> getStudentGroup();
}
