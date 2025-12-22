package com.omsu.gorch825.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omsu.gorch825.controller.StudentController;
import com.omsu.gorch825.controller.StudentGroupController;
import com.omsu.gorch825.dto.Request.Student.*;
import com.omsu.gorch825.dto.Request.StudentGroup.*;
import com.omsu.gorch825.models.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpConnectionWorkerThread extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);
    private final Socket socket;
    private final ObjectMapper mapper = new ObjectMapper();

    // В реальном проекте они передаются через конструктор (Dependency Injection)
    private final StudentController studentController;
    private final StudentGroupController groupController;

    public HttpConnectionWorkerThread(Socket socket, StudentController studentController, StudentGroupController groupController) {
        this.socket = socket;
        this.studentController = studentController;
        this.groupController = groupController;
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            // 1. Читаем запрос
            String requestLine = reader.readLine();
            if (requestLine == null) return;
            String[] parts = requestLine.split(" ");
            String method = parts[0];
            String path = parts[1];

            // 2. Читаем Content-Length
            int contentLength = 0;
            String header;
            while (!(header = reader.readLine()).isEmpty()) {
                if (header.toLowerCase().startsWith("content-length:")) {
                    contentLength = Integer.parseInt(header.split(":")[1].trim());
                }
            }

            // 3. Читаем Body
            String body = "";
            if (contentLength > 0) {
                char[] buffer = new char[contentLength];
                reader.read(buffer, 0, contentLength);
                body = new String(buffer);
            }

            LOGGER.info("API Request: {} {}", method, path);

            // 4. МАРШРУТИЗАЦИЯ К КОНТРОЛЛЕРАМ
            ResponseEntity<?> result;

            try {
                result = switch (path) {
                    // Группы
                    case "/getStudentGroups" -> groupController.getStudentGroups(mapper.readValue(body, GetStudentGroupsRequest.class));
                    case "/addStudentGroup" -> groupController.addGroup(mapper.readValue(body, AddStudentGroupRequest.class));
                    case "/getStudentGroupById" -> groupController.getStudentGroupById(mapper.readValue(body, GetStudentGroupByIdRequest.class));
                    case "/editStudentGroup" -> groupController.editStudentGroup(mapper.readValue(body, EditStudentGroupRequest.class));
                    case "/deleteStudentGroup" -> groupController.deleteStudentGroup(mapper.readValue(body, DeleteStudentGroupRequest.class));

                    // Студенты
                    case "/getStudentsByGroup" -> studentController.getStudentsByGroup(mapper.readValue(body, GetStudentsByGroupRequest.class));
                    case "/getStudentById" -> studentController.getStudentById(mapper.readValue(body, GetStudentByIdRequest.class));
                    case "/addStudent" -> studentController.addStudent(mapper.readValue(body, AddStudentRequest.class));
                    case "/editStudent" -> studentController.editStudent(mapper.readValue(body, EditStudentRequest.class));
                    case "/deleteStudentStatus" -> studentController.deleteStudentUpdateStatusExpelled(mapper.readValue(body, DeleteStudentRequest.class));
                    case "/deleteStudentFull" -> studentController.deleteStudentFromBd(mapper.readValue(body, DeleteStudentRequest.class));

                    default -> new ResponseEntity<>("Path not found", 404);
                };
            } catch (Exception e) {
                LOGGER.error("Processing error", e);
                result = new ResponseEntity<>("Error: " + e.getMessage(), 400);
            }

            // 5. ОТПРАВКА ОТВЕТА (используем код из ResponseEntity)
            String responseBody = mapper.writeValueAsString(result.getData());
            byte[] bodyBytes = responseBody.getBytes(StandardCharsets.UTF_8);

            String responseHeader = "HTTP/1.1 " + result.getStatus() + " " + getStatusText(result.getStatus()) + "\r\n" +
                    "Content-Type: application/json; charset=utf-8\r\n" +
                    "Content-Length: " + bodyBytes.length + "\r\n" +
                    "Connection: close\r\n\r\n";

            output.write(responseHeader.getBytes());
            output.write(bodyBytes);
            output.flush();

        } catch (Exception e) {
            LOGGER.error("Critical worker error", e);
        }
    }

    private String getStatusText(int code) {
        return switch (code) {
            case 200 -> "OK";
            case 201 -> "Created";
            case 204 -> "No Content";
            case 400 -> "Bad Request";
            case 404 -> "Not Found";
            default -> "Server Error";
        };
    }
}