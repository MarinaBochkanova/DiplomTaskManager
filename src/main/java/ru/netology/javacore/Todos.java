package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private List<String> taskList = new ArrayList<>();

    public List<String> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<String> taskList) {
        this.taskList = taskList;
    }

    public void addTask(String task) {
        taskList.add(task);
    }

    public void removeTask(String task) {
        taskList.remove(task);

    }

    public String getAllTasks() {
        List<String> sortTaskList = taskList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        StringBuilder allTasks = new StringBuilder();
        for (String oneTask : sortTaskList) {
            allTasks.append(oneTask);
            allTasks.append(" ");
        }
        return String.valueOf(allTasks);
    }

}
