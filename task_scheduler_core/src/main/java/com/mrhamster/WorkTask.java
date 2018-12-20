package com.mrhamster;

import java.time.LocalDateTime;

public class WorkTask {
    private String name;
    private Integer estimatedTimeInMinutes;
    private Priority priority = Priority.MEDIUM;
    private LocalDateTime creationTime = LocalDateTime.now();

    public WorkTask(String name, Integer estimatedTimeInMinutes) {
        this.name = name;
        this.estimatedTimeInMinutes = estimatedTimeInMinutes;
    }

    public WorkTask(String name, Integer estimatedTimeInMinutes, Priority priority) {
        this(name, estimatedTimeInMinutes);
        this.priority = priority;
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

    public void splitTaskPart(){

    }
}
