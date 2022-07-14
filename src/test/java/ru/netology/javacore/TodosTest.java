package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @Test
    void testAddTask() {
        Todos todos = new Todos();
        String task = "Пробежка";
        todos.addTask(task);
        String taskList = todos.getAllTasks();
        boolean result = taskList.contains("Пробежка");
        Assertions.assertTrue(result);
    }

    @Test
    void testRemoveTask() {
        Todos todos = new Todos();
        todos.addTask("Пробежка");
        String task = "Пробежка";
        todos.removeTask(task);
        String taskList = todos.getAllTasks();
        boolean result = taskList.contains("Пробежка");
        Assertions.assertFalse(result);
    }

    @Test
    void getAllTasks() {
        Todos todos = new Todos();
        todos.addTask("Зарядка");
        todos.addTask("Доделать диплом");
        todos.addTask("Встреча");
        todos.addTask("Отчет");
        String expected = "Встреча Доделать диплом Зарядка Отчет ";
        String actual = todos.getAllTasks();
        Assertions.assertEquals(expected, actual);
    }
}