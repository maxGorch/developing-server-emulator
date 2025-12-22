package com.omsu.gorch825.service;

import com.omsu.gorch825.controller.StudentController;
import com.omsu.gorch825.controller.StudentGroupController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerListenerThread.class);

    private final int port;
    private final ServerSocket serverSocket;

    // Эти зависимости приходят из AppServer один раз при старте
    private final StudentController studentController;
    private final StudentGroupController groupController;

    public ServerListenerThread(int port, StudentController sc, StudentGroupController sgc) throws IOException {
        this.port = port;
        this.studentController = sc;
        this.groupController = sgc;
        this.serverSocket = new ServerSocket(this.port);
    }

    @Override
    public void run() {
        try {
            while (serverSocket.isBound() && !serverSocket.isClosed()) {
                LOGGER.info("Ожидание нового подключения на порту {}...", port);

                // 1. Принимаем соединение
                Socket socket = serverSocket.accept();
                LOGGER.info("Подключение принято: " + socket.getInetAddress());

                // 2. Создаем Воркера и передаем ему сокет И готовые контроллеры
                HttpConnectionWorkerThread worker = new HttpConnectionWorkerThread(
                        socket,
                        studentController,
                        groupController
                );

                // 3. Запускаем воркера в отдельном потоке
                worker.start();
            }
        } catch (IOException e) {
            LOGGER.error("Ошибка при работе ServerSocket", e);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    LOGGER.error("Ошибка при закрытии ServerSocket", e);
                }
            }
        }
    }
}