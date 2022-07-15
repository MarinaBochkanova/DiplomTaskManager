package ru.netology.javacore;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException {
        Todos todos = new Todos();
        TodoServer server = new TodoServer(8989, todos);
        server.start();
    }
}
