package com.mrhamster.controller;

import com.mrhamster.model.Priority;
import com.mrhamster.model.WorkTask;
import com.mrhamster.view.TaskSchedulerMessages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskControllerImpl implements TaskController {

    private static Logger log = LogManager.getLogger(TaskControllerImpl.class);

    private List<WorkTask> tasks = new ArrayList<>();

    @Override
    public void createTask(String name, Integer estimatedExecutionTime, Priority priority) {
        WorkTask newTask = new WorkTask(name, estimatedExecutionTime, priority);
        tasks.add(newTask);
        log.info(() -> new ParameterizedMessage(TaskSchedulerMessages.TASK_CREATED_SUCCESSFULLY, name));
    }

    @Override
    public void createTask(String name, Integer estimatedExecutionTime) {
        WorkTask newTask = new WorkTask(name, estimatedExecutionTime);
        tasks.add(newTask);
        log.info(() -> new ParameterizedMessage(TaskSchedulerMessages.TASK_CREATED_SUCCESSFULLY, name));
    }

    @Override
    public void deleteTask(String name) {
        tasks.removeIf(r -> r.getName().equals(name));
        log.info(() -> new ParameterizedMessage(TaskSchedulerMessages.TASK_DELETED_SUCCESSFULLY, "name", name));
    }

    @Override
    public void deleteTask(Integer id) {
        tasks.removeIf(r -> id.equals(r.getId()));
        log.info(() -> new ParameterizedMessage(TaskSchedulerMessages.TASK_DELETED_SUCCESSFULLY, "id", id));
    }

    @Override
    public void updateTask(WorkTask task) {
        throw new UnsupportedOperationException();
    }

    public List<WorkTask> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public List<WorkTask> getTasks(Predicate<WorkTask> filter) {
        return Collections.unmodifiableList(tasks.stream().filter(filter).collect(Collectors.toList()));
    }
}
