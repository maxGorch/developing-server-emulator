package com.omsu.gorch825.service;

import com.omsu.gorch825.controller.StudentController;
import com.omsu.gorch825.controller.StudentGroupController;
import com.omsu.gorch825.httpserver.Configuration;
import com.omsu.gorch825.httpserver.ConfigurationManager;
import com.omsu.gorch825.models.Student.Student;
import com.omsu.gorch825.models.StudentGroup.StudentGroup;
import com.omsu.gorch825.repository.IGroupStudentRepositories;
import com.omsu.gorch825.repository.IStudentRepositories;
import com.omsu.gorch825.validation.Student.*;
import com.omsu.gorch825.validation.StudentGroup.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class AppServer {
    private final static Logger LOGGER = LoggerFactory.getLogger(AppServer.class);

    public static void main(String[] args) {
        LOGGER.info("Инициализация компонентов системы...");

        try {
            // 1. Загрузка конфигурации (Этап 1)
            ConfigurationManager.getInstance().loadConfigurationFile("http.json");
            Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

            // 2. Инициализация Репозиториев (Слой данных)
            IGroupStudentRepositories groupRepo = new IGroupStudentRepositories() {

                private final Map<Long, StudentGroup> groups = new HashMap<>();
                private final AtomicLong idGenerator = new AtomicLong(1);

                @Override
                public Long addStudentGroup(StudentGroup model) {
                    long id = idGenerator.getAndIncrement();
                    model = new StudentGroup(id,model.getNameGroup());
                    groups.put(id, model);
                    return id;
                }

                @Override
                public void editStudentGroup(StudentGroup model) {
                    if (model.getId() != null && groups.containsKey(model.getId())) {
                        groups.put(model.getId(), model);
                    }
                }

                @Override
                public void deleteStudentGroup(Long idEntity) {
                    groups.remove(idEntity);
                }

                @Override
                public StudentGroup getStudentGroupById(Long idEntity) {
                    return groups.get(idEntity);
                }

                @Override
                public List<StudentGroup> getStudentGroup() {
                    return new ArrayList<>(groups.values());
                }
            };
            IStudentRepositories studentRepo = new IStudentRepositories() {

                private final Map<Long, Student> students = new HashMap<>();
                private final AtomicLong idGenerator = new AtomicLong(1);

                @Override
                public Long addStudent(Student model) {
                    long id = idGenerator.getAndIncrement();
                    model.setId(id);
                    students.put(id, model);
                    return id;
                }

                @Override
                public void editStudent(Student model) {
                    if (model.getId() != null && students.containsKey(model.getId())) {
                        students.put(model.getId(), model);
                    }
                }

                @Override
                public void deleteStudent(Long idEntity) {
                    students.remove(idEntity);
                }

                @Override
                public Student getStudentById(Long idEntity) {
                    return students.get(idEntity);
                }

                @Override
                public List<Student> getAllStudent() {
                    return new ArrayList<>(students.values());
                }
            };

            // 3. Инициализация Валидаторов для Студентов
            AddStudentRequestValidator addStudentVal = new AddStudentRequestValidator();
            GetStudentByIdRequestValidator getStudentByIdVal = new GetStudentByIdRequestValidator();
            DeleteStudentRequestValidator delStudentVal = new DeleteStudentRequestValidator();
            EditStudentRequestValidator editStudentVal = new EditStudentRequestValidator();
            GetStudentsByGroupRequestValidator getByGroupVal = new GetStudentsByGroupRequestValidator();

            // 4. Инициализация Валидаторов для Групп
            AddStudentGroupRequestValidator addGroupVal = new AddStudentGroupRequestValidator();
            GetStudentGroupsRequestValidator getGroupsVal = new GetStudentGroupsRequestValidator();
            DeleteStudentGroupRequestValidator delGroupVal = new DeleteStudentGroupRequestValidator();
            EditStudentGroupRequestValidator editGroupVal = new EditStudentGroupRequestValidator();
            GetStudentGroupByIdRequestValidator getGroupByIdVal = new GetStudentGroupByIdRequestValidator();

            // 5. Создание Контроллеров
            StudentController studentController = new StudentController(
                    studentRepo, addStudentVal, groupRepo,
                    getStudentByIdVal, delStudentVal, editStudentVal, getByGroupVal
            );

            StudentGroupController groupController = new StudentGroupController(
                    groupRepo, studentRepo, addGroupVal,
                    getGroupsVal, delGroupVal, editGroupVal, getGroupByIdVal
            );

            LOGGER.info("Контроллеры и валидаторы успешно созданы.");

            // 6. Запуск сетевого прослушивателя
            // Передаем контроллеры в Listener, чтобы он отдал их в WorkerThread
            ServerListenerThread serverListenerThread = new ServerListenerThread(
                    conf.getPort(),
                    studentController,
                    groupController
            );

            serverListenerThread.start();
            LOGGER.info("Сервер запущен и ожидает подключений на порту: " + conf.getPort());

        } catch (Exception e) {
            LOGGER.error("Критическая ошибка при запуске сервера", e);
            System.exit(1);
        }
    }
}