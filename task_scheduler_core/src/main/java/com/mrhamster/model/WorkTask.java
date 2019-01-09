package com.mrhamster.model;

import com.mrhamster.utils.IdGenerator;

import java.time.LocalDateTime;

public class WorkTask {
    private Integer id = IdGenerator.generateId(WorkTask.class);
    private Priority priority = Priority.MEDIUM;
    private LocalDateTime creationTime = LocalDateTime.now();
    private WorkTaskStatus status = WorkTaskStatus.NOT_SCHEDULED;
    private String name;
    private Integer estimatedTimeInMinutes;

    public WorkTask(String name, Integer estimatedTimeInMinutes) {
        this.name = name;
        this.estimatedTimeInMinutes = estimatedTimeInMinutes;
    }

    public WorkTask(String name, Integer estimatedTimeInMinutes, Priority priority) {
        this(name, estimatedTimeInMinutes);
        this.priority = priority;
    }

    public void setStatus(WorkTaskStatus status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getEstimatedTimeInMinutes() {
        return estimatedTimeInMinutes;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
