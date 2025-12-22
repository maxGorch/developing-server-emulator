package com.omsu.gorch825.service;

import com.google.gson.Gson;
import com.omsu.gorch825.controller.StudentGroupController;
import com.omsu.gorch825.dto.Request.StudentGroup.*;
import com.omsu.gorch825.models.ResponseEntity;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StudentGroupHandler implements HttpHandler {

    private final StudentGroupController controller;
    private final Gson gson = new Gson();

    public StudentGroupHandler(StudentGroupController controller) {
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

        if (path.endsWith("/getStudentGroups")) {
            GetStudentGroupsRequest req = gson.fromJson(body, GetStudentGroupsRequest.class);
            response = controller.getStudentGroups(req);

        } else if (path.endsWith("/addStudentGroup")) {
            AddStudentGroupRequest req = gson.fromJson(body, AddStudentGroupRequest.class);
            response = controller.addGroup(req);

        } else if (path.endsWith("/deleteStudentGroup")) {
            DeleteStudentGroupRequest req = gson.fromJson(body, DeleteStudentGroupRequest.class);
            response = controller.deleteStudentGroup(req);

        } else if (path.endsWith("/editStudentGroup")) {
            EditStudentGroupRequest req = gson.fromJson(body, EditStudentGroupRequest.class);
            response = controller.editStudentGroup(req);

        } else if (path.endsWith("/getStudentGroupById")) {
            GetStudentGroupByIdRequest req = gson.fromJson(body, GetStudentGroupByIdRequest.class);
            response = controller.getStudentGroupById(req);

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
