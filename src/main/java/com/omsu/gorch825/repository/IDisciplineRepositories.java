package com.omsu.gorch825.repository;

import com.omsu.gorch825.models.Discipline.Discipline;

import java.util.List;

public interface IDisciplineRepositories
{
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
    Long addDiscipline(Discipline model);

    /**
     * @editEntity  - редактирование существующей сущности
     * @model - на входе сущность с непустым id, входная
     *         сущность подменяет старую
     * */
    void editDiscipline(Discipline model);

    /**
     * @deleteEntity - удаление сущности по id;
     * @idEntity - id  сущности
     * */
    void deleteDiscipline(Long idEntity);

    /**
     * @getEntityById - получение сущности по id и возвращает объект этой сущности как результат;
     * @idEntity - id  сущности
     * */
    Discipline getDisciplineById(Long idEntity);

    /**
     * @getAllEntity - получение всех сущностей;
     * */
    List<Discipline> getDiscipline();
}
