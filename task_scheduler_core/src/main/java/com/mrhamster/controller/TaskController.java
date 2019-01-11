package com.mrhamster.controller;

import com.mrhamster.model.Priority;
import com.mrhamster.model.WorkTask;

import java.time.Duration;

public interface TaskController {
    void createTask(String name, Duration estimatedExecutionTime, Priority priority);
    void createTask(String name, Duration estimatedExecutionTime);
    void deleteTask(String name);
    void deleteTask(Integer id);
    void updateTask(WorkTask task);
}
