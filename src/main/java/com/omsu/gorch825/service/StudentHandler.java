package com.omsu.gorch825.service;

import com.google.gson.Gson;
import com.omsu.gorch825.controller.StudentController;
import com.omsu.gorch825.dto.Request.Student.*;
import com.omsu.gorch825.models.ResponseEntity;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StudentHandler implements HttpHandler {

    private final StudentController controller;
    private final Gson gson = new Gson();

    public StudentHandler(StudentController controller) {
        this.controller = controller;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String path = exchange.getRequestURI().getPath();
        String body = new String(
                exchange.getRequestBody().readAllBytes(),
                StandardCharsets.UTF_8
        );

        ResponseEntity<?> response;

        if (path.endsWith("/addStudent")) {
            AddStudentRequest req = gson.fromJson(body, AddStudentRequest.class);
            response = controller.addStudent(req);

        } else if (path.endsWith("/getStudentById")) {
            GetStudentByIdRequest req = gson.fromJson(body, GetStudentByIdRequest.class);
            response = controller.getStudentById(req);

        } else if (path.endsWith("/editStudent")) {
            EditStudentRequest req = gson.fromJson(body, EditStudentRequest.class);
            response = controller.editStudent(req);

        } else if (path.endsWith("/deleteStudent")) {
            DeleteStudentRequest req = gson.fromJson(body, DeleteStudentRequest.class);
            response = controller.deleteStudentFromBd(req);

        } else if (path.endsWith("/getStudentsByGroup")) {
            GetStudentsByGroupRequest req = gson.fromJson(body, GetStudentsByGroupRequest.class);
            response = controller.getStudentsByGroup(req);

        } else {
            exchange.sendResponseHeaders(404, 0);
            exchange.close();
            return;
        }

        byte[] respBytes = response.getData() == null
                ? new byte[0]
                : gson.toJson(response.getData()).getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(response.getStatus(), respBytes.length);
        exchange.getResponseBody().write(respBytes);
        exchange.close();
    }
}
