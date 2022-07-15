package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream());) {

                    JsonParser parser = new JsonParser();
                    Object object = parser.parse(in.readLine());
                    JsonObject jsonObject = (JsonObject) object;
                    JsonElement typeElement = jsonObject.get("type");
                    String type = typeElement.getAsString();
                    JsonElement taskElement = jsonObject.get("task");
                    String task = taskElement.getAsString();

                    if (type.equals("REMOVE")) {
                        todos.removeTask(task);
                    } else if (type.equals("ADD")) {
                        todos.addTask(task);
                    }
                    String allTaskList = todos.getAllTasks();
                    System.out.println(allTaskList);
                }
            }
//        }catch (IOException e){
//            System.out.println("Не могу стартовать сервер");
//            e.printStackTrace();
//        }
        }
    }
}
