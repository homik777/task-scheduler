package com.mrhamster.controller;

import com.mrhamster.model.Priority;

public interface TaskController {
    void createTask(String name, Integer estimatedExecutionTime, Priority priority);
    void createTask(String name, Integer estimatedExecutionTime);
    void deleteTask(String name);
    void deleteTask(Integer id);
}
